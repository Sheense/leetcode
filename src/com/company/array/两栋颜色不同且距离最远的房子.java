package com.company.array;

/**
 * @Classname 两栋颜色不同且距离最远的房子
 * @Date 2021/11/21 10:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两栋颜色不同且距离最远的房子 {
    public int maxDistance(int[] colors) {
        int max = 0;
        for(int i = 0; i < colors.length; i++) {
            for(int j = i + 1; j < colors.length; j++) {
                if(colors[i] != colors[j]) {
                    max = Math.max(max, Math.abs(i - j));
                }
            }
        }
        return max;
    }
}
