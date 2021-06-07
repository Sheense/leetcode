package com.company.math;

public class _4的幂 {
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        while (n!=1 && n%4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
