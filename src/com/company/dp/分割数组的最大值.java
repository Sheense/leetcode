package com.company.dp;

public class 分割数组的最大值 {
    public static void main(String[] args) {
        分割数组的最大值 s = new 分割数组的最大值();
        System.out.println(s.splitArray(new int[]{7,2,5,10,8},2));
    }
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m];
        for(int i=1;i<nums.length;i++) {
            nums[i] = nums[i]+nums[i-1];
        }
        dp[0][0] = nums[0];
        for(int i=0;i<nums.length;i++) {
            for(int k=0;k<=i&&k<m;k++) {
                if(k==0) {
                    dp[i][k] = nums[i];
                    continue;
                }
                for (int z=0;z<i;z++) {
                    int item = Math.max(dp[z][k-1],nums[i]-nums[z]);
                    dp[i][k] = dp[i][k]==0?item:Math.min(item, dp[i][k]);
                }
            }
        }
        return dp[nums.length-1][m-1];
    }
}
