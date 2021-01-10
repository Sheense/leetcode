package com.company.math;

public class
丑数 {
    public boolean isUgly(int num) {
        if(num==0) return false;
        boolean flag = true;
        while(flag) {
            flag = false;
            if(num%2==0) {
                num/=2;
                flag = true;
            }
            if(num%5==0) {
                num/=5;
                flag = true;
            }
            if(num%3==0) {
                num/=3;
                flag = true;
            }
        }
        if(num==1) return true;
        return false;
    }
}
