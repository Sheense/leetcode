package com.company.dp;

public class 剪绳子 {
    public int cuttingRope(int n) {
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            if(i==1) dp[i]=1;
            else {
                for(int j=i-1;j>=1;j--) {
                    dp[i] = Math.max(Math.max(dp[j]*(i-j),dp[i]), j*(i-j));
                }
            }
        }
        return dp[n];
    }
}
