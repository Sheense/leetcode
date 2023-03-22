package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 骑士拨号器
 * @Date 2023/3/3 6:12 下午
 * @Created by sheen
 * @Description TODO
 */
public class 骑士拨号器 {
    public int knightDialer(int n) {
        int[][] map = new int[][]{
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {0, 3, 9},
                {},
                {0, 1, 7},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int mod = (int)Math.pow(10, 9) + 7;
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                for(int from : map[j]) {
                    dp[i][j] += dp[i - 1][from];
                    dp[i][j] %= mod;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < dp[n - 1].length; i++) {
            res += dp[n - 1][i];
            res %= mod;
        }

        return res;
    }
}
