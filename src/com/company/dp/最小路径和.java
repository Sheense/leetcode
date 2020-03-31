package com.company.dp;

public class 最小路径和 {
    public static void main(String[] args) {
        最小路径和 s = new 最小路径和();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(s.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(i==0&&j==0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if(i==0) {
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                    continue;
                }
                if(j==0){
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
