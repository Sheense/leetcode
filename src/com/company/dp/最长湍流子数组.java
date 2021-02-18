package com.company.dp;

public class 最长湍流子数组 {
    public static void main(String[] args) {
        最长湍流子数组 s = new 最长湍流子数组();
        System.out.println(s.maxTurbulenceSize(new int[]{100}));
    }
    public int maxTurbulenceSize(int[] A) {
        int dp[][] = new int[A.length][2];
        int max1 = 1;
        int max2 = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        int res = 1;
        for(int i=1;i<A.length;i++) {
            if((i-1)%2==0) {
                if(A[i-1]<A[i]) {
                    max1 ++;
                    max2 = 1;
                }else if(A[i-1]>A[i]){
                    max1 = 1;
                    max2 ++;
                } else{
                    max1 = 1;
                    max2 = 1;
                }
            }else {
                if(A[i-1]<A[i]) {
                    max1 = 1;
                    max2 ++;
                }else if(A[i-1]>A[i]){
                    max1 ++;
                    max2 = 1;
                } else{
                    max1 = 1;
                    max2 = 1;
                }
            }
            res = Math.max(res, Math.max(max1,max2));
        }
        return res;
    }
}
