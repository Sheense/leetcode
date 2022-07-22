package sheen.leetcode.math;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        圆圈中最后剩下的数字 s = new 圆圈中最后剩下的数字();
        System.out.println(s.lastRemaining(5,3));
    }

    public int lastRemaining(int n, int m) {
        if(n==1) {
            return 0;
        }
        int x = lastRemaining(n-1,m);
        return (m+x)%n;
    }
}
