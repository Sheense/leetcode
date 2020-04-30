package com.company.dp;

import com.company.util.ArrayUtils;

public class 完全平方数 {

    public static void main(String[] args) {
        完全平方数 s = new 完全平方数();
        System.out.println(s.numSquares(12));
    }


    public int numSquares(int n) {
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            if(i==1) dp[i]=1;
            else {
                int min = Integer.MAX_VALUE;
                int a = (int)Math.sqrt(i);
                while(a!=0) {
                    int value =i - (a*a);
                    min = min<1+dp[value]?min:1+dp[value];
                    a--;
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
