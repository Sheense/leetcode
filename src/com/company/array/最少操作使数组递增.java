package com.company.array;

public class 最少操作使数组递增 {
    public int minOperations(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] >= nums[i+1]) {
                int old = nums[i+1];
                nums[i+1] = nums[i] + 1;
                res += (nums[i+1] - old) ;
            }
        }
        return res;
    }
}
