package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname K次取反后最大化的数组和
 * @Date 2021/12/3 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        while (k--!=0) {
            int value = queue.poll();
            queue.offer(-value);
        }

        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }
}
