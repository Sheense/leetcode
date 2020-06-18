package com.company.dp;

public class 丑数II {

    public static void main(String[] args) {
        丑数II s = new 丑数II();
        System.out.println(s.nthUglyNumber(1600));
    }
    public int nthUglyNumber(int n) {
        if(n<=1) {
           return 1;
        }
        int [] dp = new int[n+1];
        dp[1] = 1;
        int arr[] = new int[]{2,3,5};
        for(int i=2;i<=n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1;j<i;j++) {
                for(int z=0;z<arr.length;z++) {
                    long temp = (long)dp[j]*arr[z];
                    if(temp<Integer.MAX_VALUE&&temp>dp[i-1]) {
                        if(min>dp[j]*arr[z]) min = dp[j]*arr[z];
                        break;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
