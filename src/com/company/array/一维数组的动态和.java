package com.company.array;

public class 一维数组的动态和 {
    public int[] runningSum(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(i!=0) {
                nums[i] = nums[i] + nums[i-1];
            }
        }
        return nums;
    }
}
