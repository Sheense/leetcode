package com.company.bitOperation;

public class 数组异或操作 {
    public int xorOperation(int n, int start) {
        int res = start;
        for(int i=1;i<n;i++) {
            res ^= start + 2*i;
        }
        return res;
    }
}
