package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 特别的排列
 * @Date 2024/6/26 01:02
 * @Created by sheen
 * @Description TODO
 */
public class 特别的排列 {
    private int mod = (int)Math.pow(10, 9) + 7;
    private int[][] dp;
    public int specialPerm(int[] nums) {
        this.dp = new int[1 << nums.length][nums.length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = (res + dfs((1 << nums.length) - 1, i, nums)) % mod;
        }

        return res;
    }

    public int dfs(int state, int i, int num[]) {
        if(dp[state][i] != -1) {
            return dp[state][i];
        }

        if((1 << i) == state) {
            return 1;
        }

        dp[state][i] = 0;
        for(int j = 0; j < num.length; j++) {
            if(i != j || ((state >> j) & 1) == 0) {
                continue;
            }

            if(num[i] % num[j] != 0 && num[j] % num[i] != 0) {
                continue;
            }
            dp[state][i] = (dp[state][i] + dfs(state ^ (1 << i), j, num)) % mod;
        }

        return dp[state][i];
    }
}
