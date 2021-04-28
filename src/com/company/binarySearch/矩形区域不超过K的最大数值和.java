package com.company.binarySearch;

import java.util.HashSet;
import java.util.Set;

public class 矩形区域不超过K的最大数值和 {
    public static void main(String[] args) {
        矩形区域不超过K的最大数值和 s = new 矩形区域不超过K的最大数值和();
        System.out.println(s.maxSumSubmatrix(new int[][]{{2,2,-1}}, 0));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int i=0;i<matrix.length;i++) {
            for(int j=1;j<matrix[0].length;j++) {
                matrix[i][j] += matrix[i][j-1];
                if(i == 0) {
                    dp[i][j] = matrix[i][j];
                }else {
                    dp[i][j] = matrix[i][j] + dp[i-1][j];
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                for(int height = 1;height<=i+1;height++) {
                    for(int width = 1;width<=j+1;width++) {
                        if(i+1 == height || j+1 == width) {
                            if(i+1==height && j+1 == width) {
                                if(dp[i][j] <= k && dp[i][j]>res) res = dp[i][j];
                            }else if(i+1==height) {
                                int value = dp[i][j] - dp[i][j - width];
                                if(value <= k && value>res) res = value;
                            }else {
                                int value = dp[i][j] - dp[i-height][j];
                                if(value <= k && value>res) res = value;
                            }
                        }else {
                            int value = dp[i][j] - dp[i][j - width] - dp[i-height][j] + dp[i-height][j-width];
                            if(value <= k && value>res) res = value;
                        }
                    }
                }
            }
        }
        return res;
    }
}
