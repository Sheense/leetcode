package com.company.math;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        double other = 1;
        if(n<0) {
            x = 1/x;
            if(n==Integer.MIN_VALUE) {
                other = x;
                n = Integer.MAX_VALUE;
            }else {
                n = -n;
            }
        }
        double a = myPow(x, n/2);
        if(n%2==0) {
            return a*a*other;
        }else {
            return a*a*x*other;
        }
    }
}
