package com.company.bitOperation;

public class 整数转换 {
    public int convertInteger(int A, int B) {
        int res = 0;
        for(int i=0;i<32;i++) {
            if((A&1)!=(B&1)) {
                res++;
            }
            A>>=1;
            B>>=1;
        }
        return res;

    }
}
