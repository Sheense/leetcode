package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 从数量最多的堆取走礼物
 * @Date 2023/10/28 00:08
 * @Created by sheen
 * @Description TODO
 */
public class 从数量最多的堆取走礼物 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int v : gifts) {
            queue.offer(v);
        }

        while (k-- != 0) {
            int v = (int)Math.sqrt(queue.poll());
            queue.offer(v);
        }

        int res = 0;
        while (!queue.isEmpty()) res += queue.poll();
        return res;
    }
}
