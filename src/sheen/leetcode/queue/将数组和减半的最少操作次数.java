package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 将数组和减半的最少操作次数
 * @Date 2022/3/19 11:24 下午
 * @Created by sheen
 * @Description TODO
 */
public class 将数组和减半的最少操作次数 {
    public int halveArray(int[] nums) {
        double all = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>((x, y) -> y - x > 0 ? 1 : -1);
        for(int i = 0; i < nums.length; i++) {
            all += nums[i];
            queue.offer(Double.valueOf(nums[i]));
        }

        double half = all / 2;
        int count = 0;
        while (all > half) {
            double v = queue.poll();
            all -= (v / 2);
            queue.offer(v / 2);
            count++;
        }
        return count;
    }
}
