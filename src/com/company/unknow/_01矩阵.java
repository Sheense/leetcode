package com.company.unknow;


import com.company.util.ArrayUtils;

public class _01矩阵 {

    public static void main(String[] args) {
        _01矩阵 s = new _01矩阵();
        int[][] matrix = {
                            {1,0,1},{1,1,1},{1,1,1}
        };
        ArrayUtils.print2(s.updateMatrix(matrix));
    }


    public int[][] updateMatrix(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++) {
                if(i==0||j==0) {
                    if(i==0&&j==0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if(i==0&&matrix[i][j]==1) {
                        if(matrix[i][j-1]==0) {
                            dp[i][j] = 1;
                        }else if(dp[i][j-1]!=0){
                            dp[i][j] = dp[i][j-1]+1;
                        }
                    }
                    if(j==0&&matrix[i][j]==1) {
                        if(matrix[i-1][j]==0) {
                            dp[i][j] = 1;
                        }else if(dp[i-1][j]!=0){
                            dp[i][j] = dp[i-1][j]+1;
                        }
                    }
                    continue;
                }
                if(matrix[i][j]==1) {
                    if(matrix[i][j-1]==0||matrix[i-1][j]==0) {
                        dp[i][j] = 1;
                    }else {
                        int min = 0;
                        if(dp[i-1][j]!=0) min = dp[i-1][j]+1;
                        if(dp[i][j-1]!=0) min = min==0||min>dp[i][j-1]?dp[i][j-1]+1:min;
                        dp[i][j] = min;
                    }
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--) {
            for(int j=matrix[i].length-1;j>=0;j--) {
                if(i==matrix.length-1&&j==matrix[i].length-1) continue;
                if(i==matrix.length-1||j==matrix[i].length-1) {
                    if(i==matrix.length-1&&matrix[i][j]==1) {
                        if(matrix[i][j+1]==0) {
                            dp[i][j] = 1;
                        }else {
                            if(dp[i][j]==0) {
                                dp[i][j] = dp[i][j+1] + 1;
                            }else {
                                dp[i][j] = dp[i][j+1] + 1>dp[i][j]?dp[i][j]:dp[i][j+1] + 1;
                            }
                        }
                    }

                    if(j==matrix[i].length-1&&matrix[i][j]==1) {
                        if(matrix[i+1][j]==0) {
                            dp[i][j] = 1;
                        }else {
                            if(dp[i][j]==0) {
                                dp[i][j] = dp[i+1][j] + 1;
                            }else {
                                dp[i][j] = dp[i+1][j] + 1>dp[i][j]?dp[i][j]:dp[i+1][j] + 1;
                            }
                        }
                    }
                    continue;
                }
                if(matrix[i][j]==1) {
                    if(matrix[i][j+1]==0||matrix[i+1][j]==0) dp[i][j]=1;
                    else {
                        int min = dp[i][j]!=0?dp[i][j]: Integer.MAX_VALUE;
                        dp[i][j] = Math.min(min,Math.min(dp[i][j+1]+1,dp[i+1][j]+1));
                    }
                }
            }
        }
        return dp;
    }

}
