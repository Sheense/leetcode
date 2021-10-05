package com.company.bitOperation;

/**
 * @Classname 两整数之和
 * @Date 2021/9/26 12:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两整数之和 {
    public static void main(String[] args) {
        两整数之和 s = new 两整数之和();
        System.out.println(s.getSum(-9, -1));
    }
    public int getSum(int a, int b) {
        while (b != 0) {
            int q = a ^ b;
            int p = a & b;
            p <<= 1;
            a = q;
            b = p;
        }
        return a;
    }
}
