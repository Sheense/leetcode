package sheen.leetcode.bitOperation;

public class 不用加号的加法 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            int d = (a & b)<<1;
            a = c;
            b = d;
        }
        return a;
    }
}
