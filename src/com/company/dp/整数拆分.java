package com.company.dp;

public class 整数拆分 {
    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                if(j==1) {
                    dp[i][1] = i;
                    continue;
                }
                if(j==i) {
                    dp[i][j] = 1;
                    continue;
                }
                for(int z=1;z<=i;z++) {
                    for(int q=1;q<j;q++) {
                        dp[i][j] = Math.max(dp[z][q]*dp[i-z][j-q], dp[i][j]);
                    }
                }
            }
        }
        int max = 0;
        for(int i=2;i<=n;i++) {
            if(dp[n][i]>max) max = dp[n][i];
        }
        return max;
    }
    public static void main(String[] args) {
        整数拆分 s = new 整数拆分();
        System.out.println(s.integerBreak(10));
    }
    /*public int integerBreak(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            int max = 1;
            for(int j=1;j<i;j++) {
                int num = Math.max(dp[j]*dp[i-j], dp[j]*(i-j));
                if(num>max) {
                    max = num;
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }*/
}
