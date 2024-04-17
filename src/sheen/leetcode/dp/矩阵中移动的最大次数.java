package sheen.leetcode.dp;

/**
 * @Classname 矩阵中移动的最大次数
 * @Date 2024/3/16 00:08
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int res = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j < grid[0].length; j++) {
            for(int i = 0; i < grid.length; i++) {
                if(grid[i][j - 1] < grid[i][j] && dp[i][j - 1] > 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                if(i - 1 >= 0 && grid[i - 1][j - 1] < grid[i][j]) {
                    if(dp[i - 1][j - 1] > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }

                if(i + 1 < grid.length && grid[i + 1][j - 1] < grid[i][j]) {
                    if(dp[i + 1][j - 1] > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                    }
                }
                res = Math.max(res, dp[i][j] - 1);
            }
        }

        return res;
    }
}
