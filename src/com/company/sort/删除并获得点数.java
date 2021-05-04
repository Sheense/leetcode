package com.company.sort;

import java.util.Arrays;

public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i<nums.length;i++) {
            int max = 0;
            for(int j = i-1;j>=0;j--) {
                if(nums[j]!=nums[i]-1) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
