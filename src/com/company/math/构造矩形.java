package com.company.math;

/**
 * @Classname 构造矩形
 * @Date 2021/10/23 1:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 构造矩形 {
    public int[] constructRectangle(int area) {
        int l = area;
        int w = 1;
        for(int i = 1; i <= area; i++) {
            if(area % i == 0) {
                if((area / i) >= i) {
                    w = i;
                    l = area / i;
                }
            }
        }
        return new int[]{l,w};
    }
}
