package com.company.dp;

import com.company.util.ArrayUtils;

public class 矩阵中的最长递增路径 {
    public static void main(String[] args) {
        矩阵中的最长递增路径 s = new 矩阵中的最长递增路径();
        System.out.println(s.longestIncreasingPath(new int[][]{
                {7,8,9},
                {9,7,6},
                {7,2,3}
        }));
    }
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        int [][] dp = new int [matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) dp[i][j] = 1;
        }
        int res = 0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(dp[i][j]==1) {
                    recall(dp,matrix,i,j);
                }
            }
        }
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                if(res<dp[i][j]) res = dp[i][j];
            }
        }
        return res;
    }
    public void recall(int[][] dp, int [][] matrix, int i, int j) {
        if (i - 1 >= 0&&matrix[i-1][j]>matrix[i][j]) {
            if(dp[i-1][j]==1) {
                recall(dp,matrix,i-1,j);
            }
            dp[i][j] = Math.max(dp[i-1][j]+1,dp[i][j]);
        }
        if (j - 1 >= 0&&matrix[i][j-1]>matrix[i][j]) {
            if(dp[i][j-1]==1) {
                recall(dp,matrix,i,j-1);
            }
            dp[i][j] = Math.max(dp[i][j-1]+1,dp[i][j]);
        }
        if (i + 1 < matrix.length&&matrix[i+1][j]>matrix[i][j]) {
            if(dp[i+1][j]==1) {
                recall(dp,matrix,i+1,j);
            }
            dp[i][j] = Math.max(dp[i+1][j]+1,dp[i][j]);
        }
        if (j + 1 < matrix[0].length&&matrix[i][j+1]>matrix[i][j]) {
            if(dp[i][j+1]==1) {
                recall(dp,matrix,i,j+1);
            }
            dp[i][j] = Math.max(dp[i][j+1]+1,dp[i][j]);
        }
    }


}
