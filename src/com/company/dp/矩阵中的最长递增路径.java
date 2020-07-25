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
        int res = 1;
        int [][] dp = new int [matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) dp[i][j] = 1;
        }
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                int max = 0;
                if(i-1>=0) {
                    if(matrix[i-1][j]<matrix[i][j]) max = Math.max(max, dp[i-1][j]);
                }
                if(i+1<matrix.length) {
                    if(matrix[i+1][j]<matrix[i][j]) max = Math.max(max, dp[i+1][j]);
                }
                if(j-1>=0) {
                    if(matrix[i][j-1]<matrix[i][j]) max = Math.max(max, dp[i][j-1]);
                }
                if(j+1<matrix[0].length) {
                    if(matrix[i][j+1]<matrix[i][j]) max = Math.max(max, dp[i][j+1]);
                }
                dp[i][j] = max+1;
                if(res<dp[i][j]) res = dp[i][j];
            }
        }

        for(int i=matrix.length-1;i>=0;i--) {
            for(int j=matrix[0].length-1;j>=0;j--) {
                int max = 0;
                if(i-1>=0) {
                    if(matrix[i-1][j]<matrix[i][j]) max = Math.max(max, dp[i-1][j]);
                }
                if(i+1<matrix.length) {
                    if(matrix[i+1][j]<matrix[i][j]) max = Math.max(max, dp[i+1][j]);
                }
                if(j-1>=0) {
                    if(matrix[i][j-1]<matrix[i][j]) max = Math.max(max, dp[i][j-1]);
                }
                if(j+1<matrix[0].length) {
                    if(matrix[i][j+1]<matrix[i][j]) max = Math.max(max, dp[i][j+1]);
                }
                dp[i][j] = Math.max(max+1, dp[i][j]);
                if(res<dp[i][j]) res = dp[i][j];
            }
        }
        return res;
    }

}
