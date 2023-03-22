package sheen.leetcode.math;

import java.util.PriorityQueue;

/**
 * @Classname 移除石子的最大得分
 * @Date 2022/12/21 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 移除石子的最大得分 {

    public static void main(String[] args) {
        移除石子的最大得分 s = new 移除石子的最大得分();
        System.out.println(s.maximumScore(6, 2, 1));
    }
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue =  new PriorityQueue<>((x, y) -> y - x);
        if(a > 0) {
            queue.add(a);
        }
        if(b > 0) {
            queue.add(b);
        }
        if(c > 0) {
            queue.add(c);
        }
        int res = 0;
        while (!queue.isEmpty() && queue.size() > 1) {
            int v1 = queue.poll();
            int v2 = queue.poll();
            if(queue.isEmpty()) {
                v1 -= v2;
                res += v2;
                if(v1 > 0) {
                    queue.add(v1);
                }
            }else {
                int count = v2 - queue.peek() + 1;
                v2 -= count;
                v1 -= count;
                res += count;
                if(v2 > 0) {
                    queue.offer(v2);
                }
                if(v1 > 0) {
                    queue.offer(v1);
                }
            }
        }

        return res;
    }
}
