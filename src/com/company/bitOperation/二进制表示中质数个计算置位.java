package com.company.bitOperation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 二进制表示中质数个计算置位
 * @Date 2022/4/5 5:00 下午
 * @Created by sheen
 * @Description TODO
 */
public class 二进制表示中质数个计算置位 {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
        int res = 0;
        for(int i = left; i <= right; i++) {
            int v = i;
            int count = 1;
            while (v != 0) {
                if(v % 2 == 1) {
                    count++;
                }
                v /= 10;
            }
            if(set.contains(count)) {
                res ++;
            }
        }
        return res;
    }

}
