package com.company.array;

public class 消失的数字 {
    public int missingNumber(int[] nums) {
        long all = (nums.length+1)*(0+nums.length)/2;
        for(int i=0;i<nums.length;i++) {
            all -= (long)nums[i];
        }
        return (int)all;
    }
}
