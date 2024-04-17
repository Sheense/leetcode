package sheen.leetcode.number;

import java.util.PriorityQueue;

/**
 * @Classname 执行K次操作后的最大分数
 * @Date 2023/10/18 00:47
 * @Created by sheen
 * @Description TODO
 */
public class 执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int i : nums) {
            queue.offer(i);
        }

        long res = 0;
        while (k -- != 0) {
            int v = queue.poll();
            res += v;
            v = (int)Math.ceil((double) v / 3);
            queue.offer(v);
        }
        return res;
    }
}
