package com.company.math;

public class 阶乘尾数 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 1) {
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
