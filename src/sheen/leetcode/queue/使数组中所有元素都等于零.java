package sheen.leetcode.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Classname 使数组中所有元素都等于零
 * @Date 2023/2/24 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使数组中所有元素都等于零 {

    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                queue.offer(nums[i]);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            PriorityQueue<Integer> nextQueue = new PriorityQueue<>();

            int v = queue.peek();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int next = queue.poll() - v;
                if(next > 0) {
                    nextQueue.offer(next);
                }
            }
            queue = nextQueue;
            res++;
        }

        return res;
    }
}
