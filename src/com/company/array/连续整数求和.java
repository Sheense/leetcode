package com.company.array;

/**
 * @Classname 连续整数求和
 * @Date 2022/6/3 5:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 连续整数求和 {
    public int consecutiveNumbersSum(int n) {
        if(n == 1) return 1;
        int res = 1;
        if(n % 2 == 1) {
            res++;
        }

        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                int v = n / i;
                if(v % 2 == 1) {
                    res++;
                }
                if(v != i && i % 2 == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
