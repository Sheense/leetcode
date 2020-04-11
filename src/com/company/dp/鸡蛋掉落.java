package com.company.dp;

import com.company.util.ArrayUtils;

public class 鸡蛋掉落 {

    public static void main(String[] args) {
        鸡蛋掉落 s = new 鸡蛋掉落();
        System.out.println(s.superEggDrop(2,6));
    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int i=1;i<=K;i++) {
            for(int j=1;j<=N;j++) {
                if(i==1) {
                    dp[i][j] = j;
                    continue;
                }
                int start = 1;
                int end = j;
                int res = Integer.MAX_VALUE;
                while(start<=end) {
                    int mid = (start+end)/2;
                    if(dp[i-1][mid-1]>=dp[i][j-mid]) {
                        end = mid - 1;
                        res = Math.min(res, dp[i-1][mid-1]);
                    }else {
                        start = mid + 1;
                        res = Math.min(res, dp[i][j-mid]);
                    }
                }
                dp[i][j] = res+1;
            }
        }
        ArrayUtils.print2(dp);
        return dp[K][N];
    }
}
