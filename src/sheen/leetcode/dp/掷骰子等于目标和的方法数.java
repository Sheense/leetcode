package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 掷骰子等于目标和的方法数
 * @Date 2023/10/24 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 掷骰子等于目标和的方法数 {

    public static void main(String[] args) {
        掷骰子等于目标和的方法数 s = new 掷骰子等于目标和的方法数();
        System.out.println(s.numRollsToTarget(1, 6, 3));
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        int mod = (int)Math.pow(10, 9) + 7;
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= target; j++) {
                for(int z = 1; z <= k; z++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }

        return dp[n][target];
    }
}
