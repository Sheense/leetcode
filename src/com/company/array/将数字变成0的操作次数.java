package com.company.array;

/**
 * @Classname 将数字变成0的操作次数
 * @Date 2022/1/31 12:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 将数字变成0的操作次数 {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if(num % 2 == 0) {
                num /= 2;
            }else {
                num -= 1;
            }
            res++;
        }
        return res;
    }
}
