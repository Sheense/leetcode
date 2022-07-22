package sheen.leetcode.math;

public class 十_二进制数的最少数目 {
    public int minPartitions(String n) {
        int res = 0;
        for(int i=0;i<n.length();i++) {
            res = Math.max(res, n.charAt(i)-'0');
        }
        return res;
    }
}
