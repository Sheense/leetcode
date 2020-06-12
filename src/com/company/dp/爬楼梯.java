package com.company.dp;

public class 爬楼梯 {

    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        int a = 1;
        int b = 2;
        for(int i=2;i<=n;i++) {
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
