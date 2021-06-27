package com.company.dp;

public class 最大子序列交替和 {
    public static void main(String[] args) {
        最大子序列交替和 s = new 最大子序列交替和();
        System.out.println(s.maxAlternatingSum(new int[]{5,6,7,8}));
    }
    public long maxAlternatingSum(int[] nums) {

        long odd = 0;
        long even = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                even = nums[i];
                odd = Integer.MIN_VALUE + 100000;
                continue;
            }

            odd = Math.max(odd, even - nums[i]);
            even = Math.max(Math.max(odd + nums[i], even), nums[i]);
        }
        return Math.max(odd, even);
    }
}
