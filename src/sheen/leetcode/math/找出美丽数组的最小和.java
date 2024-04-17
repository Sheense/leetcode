package sheen.leetcode.math;

/**
 * @Classname 找出美丽数组的最小和
 * @Date 2024/3/8 00:41
 * @Created by sheen
 * @Description TODO
 */
public class 找出美丽数组的最小和 {
    public int minimumPossibleSum(int n, int target) {
        int Mod = (int)Math.pow(10, 9) + 7;
        int m = target / 2;
        if(n <= m) {
            return (int)((long)n * (n + 1) / 2 % Mod);
        }

        return (int)(((long)m * (m + 1) / 2 % Mod +  (n - m) * (2 * (long)target + n - m - 1) / 2) % Mod);
    }
}
