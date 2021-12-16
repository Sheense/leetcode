package com.company.array;

/**
 * @Classname 范围求和II
 * @Date 2021/11/7 12:32 下午
 * @Created by sheen
 * @Description TODO
 */
public class 范围求和II {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m * n;
        int a = ops[0][0];
        int b = ops[0][1];
        for(int i = 0 ; i < ops.length; i++) {
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a * b;
    }
}
