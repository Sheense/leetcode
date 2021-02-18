package com.company.window;

public class 最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        while(left<nums.length) {
            if(nums[left]==1) {
                while(right<nums.length&&nums[right]==1) {
                    right++;
                }
                max = Math.max(max, right - left + 1);
                left = right;
            }else {
                left ++;
                right++;
            }
        }
        return max;
    }
}
