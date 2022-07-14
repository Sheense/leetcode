package com.company.math;

/**
 * @Classname 质数排列
 * @Date 2022/6/30 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 质数排列 {
    public static void main(String[] args) {
        质数排列 s = new 质数排列();
        System.out.println(s.numPrimeArrangements(5));
    }
    public int numPrimeArrangements(int n) {
        int count = 0;
        for(int i = 2; i <= n; i++) {
            int c = 1;
            for(int j = 1; j <= Math.sqrt(i); j++) {
                if(i % j == 0) c++;
            }
            if(c == 2) {
                count++;
            }
        }
        long res = 1;
        int mod = (int)Math.pow(10, 9) + 7;
        for(int i = count; i >= 1; i--){
            res *= i;
            res %= mod;
        }
        for(int i = n - count; i >= 1; i--) {
            res *= i;
            res %= mod;
        }
        return (int) res;
    }
}
