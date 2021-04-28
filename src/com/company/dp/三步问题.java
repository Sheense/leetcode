package com.company.dp;

public class 三步问题 {
    public static void main(String[] args) {
        三步问题 s = new 三步问题();
        System.out.println(s.waysToStep(5));
    }
    public int waysToStep(int n) {
        long first = 1;
        long second = 2;
        long third = 4;
        if(n<4) {
            switch (n) {
                case 1: return 1;
                case 2: return 2;
                case 3: return 4;
            }
        }
        int mod = (int)Math.pow(10, 9) + 7;
        System.out.println(mod);
        for(int i=4;i<=n;i++) {
            long res = (third + first*4 + second*2);
            first = second % mod;
            second = third % mod;
            res %= mod;
            third = res;
        }
        return (int)third;
    }
}
