package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 移除石子使总数最小
 * @Date 2023/12/23 11:16
 * @Created by sheen
 * @Description TODO
 */
public class 移除石子使总数最小 {
    public static void main(String[] args) {
        int v = 10000;
        for(int i = 0; i < 10000; i++) {
            v /= 2;
        }
        System.out.println(v);
    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int v : piles) {
            queue.offer(v);
        }

        for(int i = 0; i < k; i++) {
            int peek = queue.poll();
            peek /= 2;
            queue.offer(peek -  (peek / 2));
        }

        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }

        return res;

    }
}
