package com.company.math;

import java.util.HashSet;
import java.util.Set;

public class _2的幂 {
    public boolean isPowerOfTwo(int n) {
        Set<Integer> set = new HashSet<>();
        long m = 1;
        set.add(1);
        while(m*2<Integer.MAX_VALUE) {
            set.add((int)m*2);
            m*=2;
        }
        if(set.contains(n)) return true;
        else return false;
    }
}
