package com.company.dp;

import java.util.Map;

public class 最长公共子序列 {
    public static void main(String[] args) {
        最长公共子序列 s = new 最长公共子序列();
        System.out.println(s.longestCommonSubsequence("abc","def"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++) {
            for(int j=0;j<text2.length();j++) {
                if (i==0 || j==0) {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1;
                    }else {
                        if(i > 0) {
                            dp[i][j] = dp[i-1][j];
                        }
                        if(j > 0) {
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                } else {
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i][j]);
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
