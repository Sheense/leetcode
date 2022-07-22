package sheen.leetcode.bitOperation;

public class 颠倒二进制位 {
    public static void main(String[] args) {
        颠倒二进制位 s = new 颠倒二进制位();
        System.out.println(s.reverseBits(  1073741823));
    }
    public int reverseBits(int n) {
        int res = 0;
        int flag = n < 0?1:0;
        for(int i=0;i<32;i++) {
            int item = n & 1;
            n>>=1;
            res<<=1;
            if(i==31) {
                res = res | flag;
                break;
            }
            res = res | item;
        }
        return res;
    }
}
