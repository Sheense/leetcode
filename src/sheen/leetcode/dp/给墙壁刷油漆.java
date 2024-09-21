package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 给墙壁刷油漆
 * @Date 2024/6/28 00:30
 * @Created by sheen
 * @Description TODO
 */
public class 给墙壁刷油漆 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[2 * n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[n] = 0;
        for(int i = 0; i < cost.length; i++) {
            int[] next = new int[2 * n + 1];
            for(int j = 0; j < 2 * n + 1; j++) {
                next[Math.min(j + time[i], 2 * n)] = Math.min(dp[j] + cost[i], next[Math.min(j + time[i], 2 * n)]);
                if(j > 0) {
                    next[j - 1] = Math.min(next[j - 1], dp[j]);
                }
            }
            dp = next;
        }

        int res = Integer.MAX_VALUE;
        for(int i = n; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
