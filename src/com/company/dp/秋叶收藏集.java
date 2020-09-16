package com.company.dp;

public class 秋叶收藏集 {
    public static void main(String[] args) {
        秋叶收藏集 s = new 秋叶收藏集();
        System.out.println(s.minimumOperations("yry"));
    }
    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length()][3];
        for(int i=0;i<leaves.length();i++) {
            if(leaves.charAt(i)=='r') {
                if(i==0) dp[i][0] = 0;
                else dp[i][0] = dp[i-1][0];
                if(i>0) {
                    if(i==1) dp[i][1] = dp[i-1][0] + 1;
                    else dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][1])+1;
                }
                if(i>1) {
                    if(i==2) dp[i][2] = dp[i-1][1];
                    else dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]);
                }
            }else {
                if(i==0) dp[i][0] = 1;
                else dp[i][0] = dp[i-1][0] + 1;
                if(i>0) {
                    if(i==1) dp[i][1] = dp[i-1][0];
                    else dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][1]);
                }
                if(i>1) {
                    if(i==2) dp[i][2] = dp[i-1][1]+1;
                    else dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) +1;
                }
            }
        }
        return dp[leaves.length()-1][2];
    }
}
