package sheen.leetcode.array;

/**
 * @Classname 第N个泰波那契数
 * @Date 2021/8/8 12:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 第N个泰波那契数 {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        return c;
    }
}
