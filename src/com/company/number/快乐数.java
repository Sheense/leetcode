package com.company.number;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 快乐数 {


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true) {
            int num = 0;
            while(n/10!=0) {
                num += Math.pow(n%10, 2);
                n /= 10;
            }
            num += Math.pow(n, 2);
            if(num==1) return true;
            if(set.contains(num)) return false;
            set.add(num);
            n = num;
        }
    }
}
