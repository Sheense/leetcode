package com.company.array;

import java.util.*;

/**
 * @Classname 找出3位偶数
 * @Date 2021/12/5 11:01 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出3位偶数 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < digits.length; i++) {
            if(digits[i]%2 == 0) {
                for(int j = 0; j < digits.length; j++) {
                    if(j == i) continue;
                    for(int z = j+1; z < digits.length; z ++) {
                        if(z == i) continue;
                        int v1 = digits[j] * 10 + digits[z];
                        int v2 = digits[z] * 10 + digits[j];
                        if(v1 >= 10) {
                            set.add(v1 * 10 + digits[i]);
                        }
                        if(v2 >= 10) {
                            set.add(v2 * 10 + digits[i]);
                        }
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for(int v : set) {
            res[index ++] = v;
        }
        Arrays.sort(res);
        return res;
    }
}
