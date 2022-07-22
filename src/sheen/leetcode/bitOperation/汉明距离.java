package sheen.leetcode.bitOperation;

public class 汉明距离 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for(int i = 0; i<=30;i++) {
            int a = x >> i;
            int b = y >> i;
            if(a%2 != b %2) {
                res++;
            }
        }
        return res;
    }
}
