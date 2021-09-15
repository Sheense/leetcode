package com.company.sort;

import java.util.Arrays;

/**
 * @Classname 学生分数的最小差值
 * @Date 2021/8/29 10:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++) {
            res = Math.min(res, nums[i+k - 1] - nums[i]);
        }
        return res;
    }
}
