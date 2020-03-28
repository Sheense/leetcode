package com.company.list;

public class 删除排序数组中的重复项 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            if(i==0) continue;
            if(nums[i]==nums[index]) continue;
            index++;
            nums[index] = nums[i];
        }
        return index+1;
    }
}
