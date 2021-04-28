package com.company.bitOperation;

public class 最大数值 {
    public static void main(String[] args) {
        最大数值 s=  new 最大数值();
        System.out.println(s.maximum(
                2147483647,-2147483648));
    }
    public int maximum(int a, int b) {
        int k = (int)(((long)a - b) >> 63);
        return (1 + k)*a - k *b;
    }
}
