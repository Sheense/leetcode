package sheen.leetcode.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 网格图中最少访问的格子数
 * @Date 2024/3/22 00:13
 * @Created by sheen
 * @Description TODO
 */
public class 网格图中最少访问的格子数 {

    public static void main(String[] args) {
        网格图中最少访问的格子数 s = new 网格图中最少访问的格子数();
        System.out.println(s.minimumVisitedCells(new int[][]{{0}, {0}, {2}, {0}}));
    }
    public int minimumVisitedCells(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        PriorityQueue<int[]>[] row = new PriorityQueue[grid.length];
        PriorityQueue<int[]>[] col = new PriorityQueue[grid[0].length];

        for(int i = 0; i < row.length; i++) {
            row[i] = new PriorityQueue<>((x, y) -> dp[x[0]][x[1]] - dp[y[0]][y[1]]);
        }
        for(int i = 0; i < col.length; i++) {
            col[i] = new PriorityQueue<>((x, y) -> dp[x[0]][x[1]] - dp[y[0]][y[1]]);
        }

        dp[0][0] = 1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[row[i].peek()[0]][row[i].peek()[1]] < j) {
                    row[i].poll();
                }
                if(!row[i].isEmpty()) {
                    dp[i][j] = max(dp[i][j], dp[row[i].peek()[0]][row[i].peek()[1]] + 1);
                }

                while (!col[j].isEmpty() && col[j].peek()[0] + grid[col[j].peek()[0]][col[j].peek()[1]] < i) {
                    col[j].poll();
                }
                if(!col[j].isEmpty()) {
                    dp[i][j] = max(dp[i][j], dp[col[j].peek()[0]][col[j].peek()[1]] + 1);
                }

                if(dp[i][j] != -1) {
                    row[i].offer(new int[]{i, j});
                    col[j].offer(new int[]{i, j});
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int max(int a, int b) {
        if(a == -1) {
            return b;
        }
        return Math.min(a, b);
    }
}
