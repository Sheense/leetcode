package com.company.bitOperation;

public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int j = n >> i;
            if((j & 1)==1)  res++;
        }
        return res;
    }
}
