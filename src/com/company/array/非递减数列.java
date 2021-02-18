package com.company.array;

public class 非递减数列 {
    public static void main(String[] args) {
        非递减数列 s = new 非递减数列();
        System.out.println(s.checkPossibility(new int[]{-1,4,2,3}));
    }
    public boolean checkPossibility(int[] nums) {
        if(nums.length==1||nums.length==2) return true;
        boolean has = false;
        for(int i=0;i<nums.length-1;i++) {
             if(i==0) {
                 if(nums[i]>nums[i+1]) {
                     nums[i] = nums[i+1];
                     has = true;
                 }
             }else {
                 if(nums[i]>nums[i+1]) {
                     if(has) return false;
                     has = true;
                     if(nums[i-1]<=nums[i+1]) {
                         nums[i] = nums[i-1];
                     }else {
                         nums[i+1] = nums[i];
                     }
                 }
             }
        }
        return true;
    }
}
