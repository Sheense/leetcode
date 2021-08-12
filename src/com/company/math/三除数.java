package com.company.math;

/**
 * @Classname 三除数
 * @Date 2021/8/1 10:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 三除数 {
    public boolean isThree(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count == 3;
    }
}
