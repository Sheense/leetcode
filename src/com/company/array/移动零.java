package com.company.array;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        int index = 0;
        while(index<nums.length) {
            if(nums[index]==0) {
                zeroNum++;
            }else {
                nums[index - zeroNum] = nums[index];
            }
            index++;
            if(index==nums.length) {
                int start = index - zeroNum;
                for(;start<nums.length;start++) {
                    nums[start] = 0;
                }
            }
        }
    }
}
