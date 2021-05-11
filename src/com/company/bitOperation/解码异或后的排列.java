package com.company.bitOperation;

public class 解码异或后的排列 {
    public int[] decode(int[] encoded) {
        int total = 1;
        for(int i=2;i<=encoded.length+1;i++) {
            total ^= i;
        }
        int ji = encoded[1];
        for(int i=2;i<encoded.length;i++) {
            if(i % 2 == 1) {
                ji ^= encoded[i];
            }
        }
        int res[] = new int [encoded.length+1];
        res[0] = total^ji;
        for(int i=1;i<res.length;i++) {
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;
    }
}
