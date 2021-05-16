package com.company.dp;

public class 停在原地的方案数 {
    public static void main(String[] args) {
        停在原地的方案数 s = new 停在原地的方案数();
        System.out.println(s.numWays(500,1000000));
    }
    public int numWays(int steps, int arrLen) {
        int mod = ((int)(Math.pow(10, 9) + 7));
        int len = Math.min(steps, arrLen);
        long [] dp = new long[len];
        for(int i = 0;i<steps;i++) {
            long[] temp = new long[len];
            for(int j = 0; j<len && j<=i+1; j++) {
                if(i == 0) {
                    temp[j] = 1;
                }else {
                    temp[j] = dp[j];
                    temp[j] %= mod;
                    if(j > 0) {
                        temp[j] += dp[j-1];
                        temp[j] %= mod;
                    }
                    if(j < len - 1) {
                        temp[j] += dp[j+1];
                        temp[j] %= mod;
                    }
                }
            }
            dp = temp;
        }
        return (int)(dp[0]);
    }
}
