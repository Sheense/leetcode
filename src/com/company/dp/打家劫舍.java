package com.company.dp;

public class 打家劫舍 {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(i==1) {
                if(nums[i]<nums[0]) {
                    nums[i] = nums[0];
                }
            }else {
                nums[i] = nums[i-1] > nums[i-2]+nums[i]?nums[i-1]:nums[i-2]+nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
