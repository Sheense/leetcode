package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 和至少为K的最短子数组
 * @Date 2022/10/26 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 和至少为K的最短子数组 {
    public static void main(String[] args) {
        和至少为K的最短子数组 s = new 和至少为K的最短子数组();
        System.out.println(s.shortestSubarray(new int[]{2,-1,2}, 3));
    }
    public int shortestSubarray(int[] nums, int k) {
        long[] preArr = new long[nums.length + 1];
        for(int i = 1; i < nums.length + 1; i++) {
            preArr[i] = preArr[i - 1] + nums[i - 1];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Long.compare(preArr[x], preArr[y]));
        int max = Integer.MAX_VALUE;
        queue.offer(0);
        for(int i = 1; i < nums.length + 1; i++) {
            while (!queue.isEmpty() && preArr[i] - preArr[queue.peek()] >= k) {
                max = Math.min(i - queue.poll(), max);
            }
            queue.offer(i);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
