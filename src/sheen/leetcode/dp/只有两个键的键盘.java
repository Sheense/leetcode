package sheen.leetcode.dp;

/**
 * @Classname 只有两个键的键盘
 * @Date 2021/9/19 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 只有两个键的键盘 {
    public static void main(String[] args) {
        只有两个键的键盘 s = new 只有两个键的键盘();
        System.out.println(s.minSteps(3));
    }
    public int minSteps(int n) {
        int [] dp = new int[n+1];
        for(int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                if(i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }
}
