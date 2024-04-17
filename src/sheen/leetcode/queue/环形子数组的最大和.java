package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 环形子数组的最大和
 * @Date 2023/7/20 00:17
 * @Created by sheen
 * @Description TODO
 */
public class 环形子数组的最大和 {
    public static void main(String[] args) {
        环形子数组的最大和 s =  new 环形子数组的最大和();
        System.out.println(s.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int now = 0;
        for(int i = 0; i < nums.length; i++) {
            now += nums[i];
            max = Math.max(max, now);
            if(now < 0) {
                now = 0;
            }
        }

        int pre[] = new int[nums.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> pre[y] - pre[x]);
        for(int i = 0; i < pre.length; i++) {
            if(i == 0) {
                pre[i] = nums[i];
            }else {
                pre[i] = pre[i - 1] + nums[i];
            }
            queue.offer(i);
        }
        now = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            now += nums[i];
            while (!queue.isEmpty() && queue.peek() >= i) {
                queue.poll();
            }
            if(!queue.isEmpty()) {
                max = Math.max(max, now + pre[queue.peek()]);
            }
        }

        return max;
    }
}
