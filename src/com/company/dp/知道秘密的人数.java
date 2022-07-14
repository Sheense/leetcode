package com.company.dp;

/**
 * @Classname 知道秘密的人数
 * @Date 2022/7/3 11:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 知道秘密的人数 {
    public static void main(String[] args) {
        知道秘密的人数 s = new 知道秘密的人数();
        System.out.println(s.peopleAwareOfSecret(4, 1, 3));
    }
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = (int)Math.pow(10 , 9 ) + 7;
        long[][] dp = new long[n][3];
        dp[0][0] = 0; //知道秘密能分享
        dp[0][1] = 1;//知道秘密不能分享
        dp[0][2] = 1;//当天知道秘密
        for(int i = 1 ; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][1];
            if(i - forget >= 0) {
                dp[i][0] -= dp[i - forget][2];
            }

            if(i - delay >= 0) {
                dp[i][0] += dp[i - delay][2];
                dp[i][1] -= dp[i - delay][2];
            }

            dp[i][1] += dp[i][0];
            dp[i][2] = dp[i][0];

            if(dp[i][0] < 0) {
                dp[i][0] += mod;
            }
            if(dp[i][1] < 0) {
                dp[i][1] += mod;
            }

            if(dp[i][2] < 0) {
                dp[i][2] += mod;
            }
            dp[i][0] %= mod;
            dp[i][1] %= mod;
            dp[i][2] %= mod;
        }


        int res = (int)(dp[n - 1][0] + dp[n - 1][1]) % mod;
        return res;
    }
}
