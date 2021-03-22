package com.company.array;

public class 最大升序子数组和 {
    public int maxAscendingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int now = 0;
        for(int i=0;i<nums.length;i++) {
            if(i==0||nums[i-1]<nums[i]) {
                now += nums[i];
            }else {
                max = Math.max(max, now);
                now = nums[i];
            }
            if(nums.length-1 == i) {
                max = Math.max(max, now);
            }
        }
        return max;
    }
}
