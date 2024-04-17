package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 最少的硬币数目
 * @Date 2023/5/5 12:31 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最少的硬币数目 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++) {
            for(int j = 1; j < coins.length; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
