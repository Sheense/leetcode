package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 满足不等式的最大值
 * @Date 2023/7/21 21:04
 * @Created by sheen
 * @Description TODO
 */
public class 满足不等式的最大值 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int num1 = points[x][1] - points[x][0];
            int num2 = points[y][1] - points[y][0];
            return num2 - num1;
        });
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++) {
            while (!queue.isEmpty() && points[i][0] - points[queue.peek()][0] > k) {
                queue.poll();
            }
            if(!queue.isEmpty()) {
                res = Math.max(res, points[queue.peek()][1] - points[queue.peek()][0] + points[i][0] + points[i][1]);
            }
            queue.offer(i);
        }
        return res;
    }
}
