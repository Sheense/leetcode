package com.company.math;

/**
 * @Classname 消除游戏
 * @Date 2022/1/2 10:28 上午
 * @Created by sheen
 * @Description TODO
 */
public class 消除游戏 {
    public int lastRemaining(int n) {
        int k = 0;
        int a1 = 1;
        int an = n;
        int cnt = n;
        int step = 1;
        while (cnt > 1) {
            if(k % 2 == 0) {
                a1 += step;
                an = cnt % 2 == 0 ? an : (an - step);
            }else {
                a1 = cnt % 2 == 0 ? a1 : (a1 + step);
                an -= step;
            }

            cnt >>= 1;
            step <<= 1;
            k++;
        }
        return a1;
    }
}
