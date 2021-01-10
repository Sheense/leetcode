package com.company.bitOperation;

public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        不用加减乘除做加法 s = new 不用加减乘除做加法();
        System.out.println(s.add(15,5));
    }
    public int add(int a, int b) {
        int x = a;
        int y = b;
        while(y!=0) {
            a = x^y;
            b= (x&y)<<1;
            x = a;
            y = b;
        }
        return x;
    }
}
