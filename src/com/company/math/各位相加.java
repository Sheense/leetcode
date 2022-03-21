package com.company.math;

/**
 * @Classname 各位相加
 * @Date 2022/3/3 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 各位相加 {
    public int addDigits(int num) {
        int n = 0;
        while (num >= 10) {
            while (num != 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
            n = 0;
        }
        return num;
    }
}
