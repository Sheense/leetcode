package com.company.dp;

public class 连续数列 {

    public int maxSubArray(int[] nums) {
        int num = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length; i++) {
            num += nums[i];
            max = Math.max(num, max);
            if (num < 0) {
                num = 0;
            }
        }
        return max;
    }
}
