package sheen.leetcode.dp;

/**
 * @Classname K个逆序对数组
 * @Date 2021/11/11 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class K个逆序对数组 {
    public static void main(String[] args) {
        K个逆序对数组 s = new K个逆序对数组();
        System.out.println(s.kInversePairs(1000,1000));
    }
    public int kInversePairs(int n, int k) {
        if(k == 0) return 1;
        int mod = (int)Math.pow(10, 9) + 7;
        long[][] dp = new long[n+1][k+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j] - (j - i >= 0 ? dp[i-1][j - i] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0);
                if (dp[i][j] >= mod) {
                    dp[i][j] -= mod;
                }
                else if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
            }
        }
        return (int)dp[n][k];
    }
}
