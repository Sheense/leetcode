package com.company.dp;

import com.company.util.ArrayUtils;

public class 最长递增子序列的个数 {

    public static void main(String[] args) {
        最长递增子序列的个数 s = new 最长递增子序列的个数();
        System.out.println(s.findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
    public int findNumberOfLIS(int[] nums) {
        int [][] dp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++) {
            dp[i][0] = 1;
            int max = 0;
            for(int j=0;j<i;j++) {
                if(dp[j][0]>max&&nums[j]<nums[i]) max = dp[j][0];
            }
            dp[i][0] += max;
            if(max==0) {
                dp[i][1] = 1;
                continue;
            }
            int n = 0;
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]&&dp[j][0]==max) {
                    n+=dp[j][1];
                }
            }
            dp[i][1] = n;
        }
        int maxLen = 1;
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(maxLen<dp[i][0])maxLen = dp[i][0];
        }
        for(int i=0;i<nums.length;i++) {
            if(maxLen==dp[i][0]) {
                res += dp[i][1];
            }
        }
        return res;
    }

}
