package com.company.dp;

public class 打家劫舍II {

    public static void main(String[] args) {
        打家劫舍II s = new 打家劫舍II();
        System.out.println(s.rob(new int[]{2,3,2}));
    }
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp1= new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp2[0] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++) {

        }
        return Math.max(dp1[nums.length-1],dp2[0]);
    }
}
