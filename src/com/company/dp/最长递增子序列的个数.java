package com.company.dp;

import com.company.util.ArrayUtils;

import java.util.Arrays;

public class 最长递增子序列的个数 {

    public static void main(String[] args) {
        最长递增子序列的个数 s = new 最长递增子序列的个数();
        System.out.println(s.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }

    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        int resLen = 0;
        for(int i = 0 ; i < nums.length; i++) {
            int maxLen = 0;
            int n = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j][0] > maxLen) {
                        maxLen = dp[j][0];
                        n = dp[j][1];
                    }else if(dp[j][0] == maxLen) {
                        n += dp[j][1];
                    }
                }
            }
            if(maxLen > 0) {
                dp[i][0] = maxLen + 1;
                dp[i][1] = n;
            }
            if(dp[i][0] > resLen) {
                resLen = dp[i][0];
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i][0] == resLen) {
                res += dp[i][1];
            }
        }
        return res;
    }
}
