package com.company.dp;

public class 执行乘法运算的最大分数 {
    public static void main(String[] args) {
        执行乘法运算的最大分数 s = new 执行乘法运算的最大分数();
        System.out.println(s.maximumScore(new int[]{1,2,3}, new int[]{3,2,1}));
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length+1][multipliers.length+1];
        for(int i=0;i<dp.length;i++) {
            for(int j =0;j<dp[i].length;j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i = 1;i<=multipliers.length;i++) {
            if(i==1) {
                dp[1][0] = nums[0] * multipliers[i-1];
                dp[0][1] = nums[nums.length-1] * multipliers[i-1];
            }else {
                for(int j = 0;j<=i;j++) {
                    int a = j == 0 ? Integer.MIN_VALUE : dp[j-1][i - j] + multipliers[i-1] * nums[j-1];
                    int b = i-j==0?Integer.MIN_VALUE : dp[j][i-j-1] + multipliers[i-1] * nums[nums.length - (i-j-1) - 1];
                    dp[j][i-j]= Math.max(Math.max(a, b), dp[j][i-j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<multipliers.length;i++) {
            max = Math.max(max, dp[i][multipliers.length-i]);
        }
        return max;
    }
}
