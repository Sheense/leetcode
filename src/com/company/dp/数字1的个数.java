package com.company.dp;

import com.company.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 数字1的个数
 * @Date 2021/8/13 12:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数字1的个数 {
    public static void main(String[] args) {
        数字1的个数 s = new 数字1的个数();
        System.out.println(s.countDigitOne(12345));
    }
    public int countDigitOne(int n) {
        long[] a = new long[10];
        for(int i = 0; i < a.length; i++) {
            if(i == 0) {
                a[i] = 1;
            }else {
                a[i] = (long)Math.pow(10, i) + a[i-1] * 10;
            }
        }
        ArrayUtils.print(a);
       return recall(n, a);

    }

    public int recall(int num, long[] a) {
        if(num == 0) return 0;
        if(num <= 9) return 1;
        int res = 0;
        int len = 0;
        while (Math.pow(10, len + 1) <= num) {
            len++;
        }
        int s = num / (int)Math.pow(10, len);
        int yu = num % (int)Math.pow(10, len);
        if(s > 1) {
            res += Math.pow(10, len);
        }else if(s == 1){
            res += yu + 1;
        }

        res += a[len- 1] * s;
        return res + recall(yu, a);
    }
}
