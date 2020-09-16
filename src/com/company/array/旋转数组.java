package com.company.array;

public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++) {
            int value = nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--){
                nums[j+1] = nums[j];
            }
            nums[0] = value;
        }
    }
}


