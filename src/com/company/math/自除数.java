package com.company.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 自除数
 * @Date 2022/3/31 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 自除数 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            int v = i;
            while (v != 0) {
                int yu = v % 10;
                if(yu == 0 || i % yu != 0) {
                    break;
                }
                v /= 10;
            }
            if(v == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
