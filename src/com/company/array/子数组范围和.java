package com.company.array;

/**
 * @Classname 子数组范围和
 * @Date 2021/12/12 10:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子数组范围和 {
    public long subArrayRanges(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = nums[i];
        }

        long res = 0;
        for(int i = 2; i <= nums.length; i++) {
            for(int j = 0; j + i - 1 < nums.length; j++) {
                dp[j][0] = Math.min(dp[j][0], nums[j + i - 1]);
                dp[j][1] = Math.max(dp[j][1], nums[j + i - 1]);
                res += dp[j][1] - dp[j][0];
            }
        }
        return res;
    }
}
