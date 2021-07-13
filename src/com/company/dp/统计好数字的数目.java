package com.company.dp;

import java.util.Map;

public class 统计好数字的数目 {


    private static final int MOD = (int)Math.pow(10, 9) + 7;
    public int countGoodNumbers(long n) {
        if(n == 1) return 5;
        long count = n / 2;
        int yu = (int)(n % 2);
        long res = pow(20, count);
        if(yu == 1) {
            res = (res * 5) % MOD;
        }
        return (int)res;
    }

    public long pow(long n, long count) {
        if(count == 1) return n;
        long c = count / 2;
        long yu = count % 2 == 1 ? n : 1;
        long r = pow(n, c);
        return ((r * r) % MOD * yu) % MOD;
    }
}
