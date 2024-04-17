package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 最小和分割
 * @Date 2023/10/9 00:02
 * @Created by sheen
 * @Description TODO
 */
public class 最小和分割 {
    public int splitNum(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (num != 0) {
            int a = num % 10;
            num /= 10;
            queue.offer(a);
        }

        int a = 0;
        int b = 0;
        while (!queue.isEmpty()) {
            a = a * 10 + queue.poll();
            if(!queue.isEmpty()) {
                b = b * 10 + queue.poll();
            }
        }
        return a + b;
    }
}
