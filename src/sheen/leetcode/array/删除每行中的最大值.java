package sheen.leetcode.array;

import java.util.PriorityQueue;

/**
 * @Classname 删除每行中的最大值
 * @Date 2023/7/27 00:04
 * @Created by sheen
 * @Description TODO
 */
public class 删除每行中的最大值 {
    public int deleteGreatestValue(int[][] grid) {
        PriorityQueue<Integer>[] queues = new PriorityQueue[grid.length];
        for(int i = 0; i < grid.length; i++) {
            queues[i] = new PriorityQueue<Integer>((x, y) -> y - x);
            for(int  j = 0; j < grid[i].length; j++) {
                queues[i].offer(grid[i][j]);
            }
        }

        int res = 0;
        for(int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < queues.length; j++) {
                max = Math.max(max, queues[j].poll());
            }
            res += max;
        }
        return res;
    }
}
