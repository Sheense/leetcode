package com.company.bitOperation;

public class 配对交换 {
    public static void main(String[] args) {
        配对交换 s = new 配对交换();
        System.out.println(s.exchangeBits(21555555));
    }
    public int exchangeBits(int num) {
        int res = 0;
        for(int i=0;i<32;i+=2) {
            int a = num&1;
            int b = (num>>1)&1;
            res |=((a<<1)|b)<<i;
            num>>=2;
        }
        return res;
    }
}
