package com.company.dp;

import com.company.util.ArrayUtils;
//f(i,v)=f(i−1,v)+f(i−1,v−ci​)+f(i−1,v−2ci​)⋯f(i−1,v−kci​)
//f(i,v−ci​)=f(i−1,v−ci​)+f(i−1,v−2ci​)+f(i−1,v−3ci​)⋯f(i−1,v−kci​)
//f(i,v)=f(i−1,v)+f(i,v−ci​)
public class 硬币 {

    public static void main(String[] args) {
        硬币 s = new 硬币();
        System.out.println(s.waysToChange(30));
    }

    public int waysToChange(int n) {
        if(n==0) return 0;
        int mod = 1000000007;
        int[][] dp = new int[4][n+1];
        for(int i=0;i<4;i++) {
            int m = 0;
            switch (i) {
                case 0 : m=1;break;
                case 1 : m=5;break;
                case 2 : m=10;break;
                case 3 : m=25;break;
            }
            for(int j=0;j<=n;j++) {
                if(i==0||j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (j-m>=0?dp[i][j-m]:0) + dp[i-1][j];
                dp[i][j] %= mod;
            }
        }
        return dp[3][n];
    }
}
