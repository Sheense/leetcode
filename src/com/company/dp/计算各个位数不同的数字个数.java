package com.company.dp;

public class 计算各个位数不同的数字个数 {
    public static void main(String[] args) {
        计算各个位数不同的数字个数 s = new 计算各个位数不同的数字个数();
        System.out.println(s.countNumbersWithUniqueDigits(11));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int res = 10;
        for(int i=2;i<=n;i++) {
            int count = 9;
            int v = 1;
            int q = 1;
            for(int j=1;j<=i;j++) {
                v *= count;
                if(j!=i) {
                    q *= count;
                }
                count--;
            }
            v += q*(i-1);
            res += v;
        }
        return res;
    }
}
