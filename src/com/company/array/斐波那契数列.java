package com.company.array;

/**
 * @Classname 斐波那契数列
 * @Date 2021/9/4 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 斐波那契数列 {
    public int fib(int n) {
        int i = 0;
        int j = 1;
        if(n == 0) return i;
        if(n == 1) return j;
        int mod = (int)Math.pow(10, 9) + 7;
        for(int z = 2; z <= n; z++) {
            int item = j;
            int all = (i + j) % mod;
            i = item;
            j = all;
        }
        return j;
    }
}
