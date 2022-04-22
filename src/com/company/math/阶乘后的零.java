package com.company.math;

/**
 * @Classname 阶乘后的零
 * @Date 2022/3/25 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        int res = 0;
        for(int i = 5; i <= n; i+=5) {
            int v = i;
            while (v % 5 == 0) {
                v /= 5;
                res++;
            }
        }
        return res;
    }
}
