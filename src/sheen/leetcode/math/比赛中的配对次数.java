package sheen.leetcode.math;

public class 比赛中的配对次数 {
    public int numberOfMatches(int n) {
        int res = 0;
        while(n>1) {
            res += (n/2);
            if (n%2==0) {
                n /= 2;
            } else {
                n = (n/2)+1;
            }
        }
        return res;
    }
}
