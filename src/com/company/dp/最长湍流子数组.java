package com.company.dp;

public class 最长湍流子数组 {
    public static void main(String[] args) {
        最长湍流子数组 s = new 最长湍流子数组();
        System.out.println(s.maxTurbulenceSize(new int[]{100}));
    }
    public int maxTurbulenceSize(int[] A) {
        int dp[][] = new int[A.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int res = 1;
        for(int i=1;i<A.length;i++) {
            if((i-1)%2==0) {
                if(A[i-1]<A[i]) {
                    dp[i][0] = dp[i-1][0] + 1;
                    dp[i][1] = 1;
                }else if(A[i-1]>A[i]){
                    dp[i][0] = 1;
                    dp[i][1] = dp[i-1][1] + 1;
                } else{
                    dp[i][0] = 1;
                    dp[i][1] = 1;
                }
            }else {
                if(A[i-1]<A[i]) {
                    dp[i][0] = 1;
                    dp[i][1] = dp[i-1][1] + 1;
                }else if(A[i-1]>A[i]){
                    dp[i][0] = dp[i-1][0] + 1;
                    dp[i][1] = 1;
                } else{
                    dp[i][0] = 1;
                    dp[i][1] = 1;
                }
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
