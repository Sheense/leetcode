package sheen.leetcode.binarySearch;

/**
 * @Classname 用三种不同颜色为网格涂色
 * @Date 2021/7/15 2:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 用三种不同颜色为网格涂色 {
    private static int MOD = (int)Math.pow(10, 9) + 7;
    public int colorTheGrid(int m, int n) {
        long res = m;
        int num = m - 1;
        int count = n - 1;
        return (int)((m * pow(num, count)) % MOD);
    }

    public long pow(long num, int count) {
        if(count == 0) return 1;
        if(count == 1) return num;
        int next = count / 2;
        int yu = count % 2;
        long r = pow(num, next);
        return (r * r * yu * num) % MOD;
    }
}
