package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname DI序列的有效排列
 * @Date 2023/3/30 3:28 下午
 * @Created by sheen
 * @Description TODO
 */
public class DI序列的有效排列 {
    public static void main(String[] args) {
        DI序列的有效排列 s = new DI序列的有效排列();
        System.out.println(s.numPermsDISequence("IDDDIIDIIIIIIIIDIDID"));
    }
    public int numPermsDISequence(String s) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[s.length()][s.length() + 1];
        dp[0][0] = s.charAt(0) == 'D' ? 1 : 0;
        dp[0][1] = s.charAt(0) == 'D' ? 0 : 1;
        for(int i = 1; i < s.length(); i++) {
            int n = i + 1;
            if(s.charAt(i) == 'D') {
                dp[i][n] = 0;
                /*for(int j = 0; j <= n - 1; j++) {
                    //这里从j开始，不是从j + 1开始，假设n=3，那么以2结尾的数量，只能找到前一轮以3为结尾，但是前一轮没有以3的，
                    // 由[0,1,2]和[0,1,3]上可以看出，以2结尾的能替代以3结尾的，递推
                    for(int z = j; z <= n - 1; z++) {
                        dp[i][j] += dp[i - 1][z];
                        dp[i][j] %= MOD;
                    }
                }*/
                //优化为O(n^2)
                for(int j = n - 1; j >= 0; j--) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % MOD;
                }
            } else {
                dp[i][0] = 0;
                /*for(int j = 1; j <= n; j++) {
                    for(int z = 0; z <= j - 1; z++) {
                        dp[i][j] += dp[i - 1][z];
                        dp[i][j] %= MOD;
                    }
                }*/
                //优化为O(n^2)
                for(int j = 1; j <= n; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % MOD;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < dp[0].length; i++) {
            res += dp[s.length() - 1][i];
            res %= MOD;
        }

        return res;
    }
}
