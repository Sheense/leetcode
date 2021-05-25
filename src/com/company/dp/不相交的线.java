package com.company.dp;

public class 不相交的线 {
    public static void main(String[] args) {
        不相交的线 s = new 不相交的线();
        System.out.println(s.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++) {
            for(int j = 0; j<nums2.length; j++) {
                if(i == 0 || j == 0){
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = 1;
                    }else {
                        if(i == 0 && j != 0) {
                            dp[i][j] = dp[i][j-1];
                        }else if(j == 0 && i != 0) {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                    continue;
                }
                if(nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
