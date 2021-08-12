package com.company.array;

/**
 * @Classname 连续子数组的最大和
 * @Date 2021/7/17 1:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int now = 0;
        for(int i = 0; i<nums.length; i++) {
            now += nums[i];
            res = Math.max(res, now);
            if(now < 0) now = 0;
        }
        return res;
    }
}
