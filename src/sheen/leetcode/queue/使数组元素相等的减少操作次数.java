package sheen.leetcode.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 使数组元素相等的减少操作次数 {
    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key : map.keySet()) {
            queue.add(key);
        }
        int res = 0;
        while (queue.size() > 1) {
            int key = queue.poll();
            res += map.get(key);
            map.put(queue.peek(), map.get(queue.peek()) + map.get(key));
        }
        return res;
    }
}
