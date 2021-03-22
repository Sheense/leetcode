package com.company.bitOperation;

public class 位1的个数 {
    public static void main(String[] args) {
        位1的个数 s = new 位1的个数();
        System.out.println(3%-2);
        System.out.println(s.hammingWeight(-3));
    }
    public int hammingWeight(int n) {
        //if(Integer.MIN_VALUE == n) return 32;
        int res = 0;
        for(int i = 0;i< 32 ;i++) {
            if(n%2 == 1 || n%-2 == -1) res++;
            n >>= 1;
        }
        return res;
    }
}
