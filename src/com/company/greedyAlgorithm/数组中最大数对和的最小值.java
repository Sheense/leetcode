package com.company.greedyAlgorithm;

import java.util.Arrays;

public class 数组中最大数对和的最小值 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length/2; i++) {
            res = Math.max(res, nums[i] + nums[nums.length-1-i]);
        }
        return res;
    }
}
