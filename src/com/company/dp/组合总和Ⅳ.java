package com.company.dp;

public class 组合总和Ⅳ {
    public static void main(String[] args) {
        组合总和Ⅳ s = new 组合总和Ⅳ();
        System.out.println(s.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=target;i++) {
            for(int j=0;j<nums.length;j++) {
                if(nums[j]<=i) {
                    dp[i]+= dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
