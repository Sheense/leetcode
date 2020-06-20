package com.company.dp;

import com.company.util.ArrayUtils;

public class 第k个数 {

    public static void main(String[] args) {
        第k个数 s = new 第k个数();
        System.out.println(s.getKthMagicNumber(7));
    }
    public int getKthMagicNumber(int k) {
        int [] dp = new int[k+1];
        dp[1] = 1;
        int[] arr ={3,5,7};
        for(int i=2;i<=k;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                for(int z=0;z<3;z++) {
                    long item = (long)dp[j]*arr[z];
                    if(item<=Integer.MAX_VALUE&&min>item&&item>dp[i-1]){
                        min = (int)item;
                        break;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[k];
    }
}
