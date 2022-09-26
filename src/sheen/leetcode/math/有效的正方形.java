package sheen.leetcode.math;

/**
 * @Classname 有效的正方形
 * @Date 2022/7/29 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效的正方形 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        if(!(judge(p1, p2) && judge(p1, p3) && judge(p1, p4) && judge(p2, p3)&& judge(p2, p4) && judge(p3, p4))) {
            return false;
        }

        int a = getLen(p1, p2);
        int b = getLen(p1, p3);
        int c = getLen(p1, p4);
        if(a == b && a != c) {
            return a + b == c && getLen(p2, p4) == getLen(p3, p4);
        }
        if(a == c && a != b) {
            return a + c == b && getLen(p2, p3) == getLen(p3, p4);
        }

        if(b == c && b != a) {
            return b + c == a && getLen(p2, p3) == getLen(p2, p4);
        }

        return false;
    }

    public int getLen(int[] p1, int[] p2) {
        return (int)(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    public boolean judge(int[] p1, int[] p2) {
        return p1[0] != p2[0] || p2[1] != p1[1];
    }
}
