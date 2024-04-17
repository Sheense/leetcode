package sheen.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 卖木头块
 * @Date 2024/3/15 00:07
 * @Created by sheen
 * @Description TODO
 */
public class 卖木头块 {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] price : prices) {
            map.put(hashKey(price[0], price[1]), price[2]);
        }

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(m, n, map, dp);
    }

    public long dfs(int x, int y, Map<Integer, Integer> map, long[][] dp) {
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        long ret = map.getOrDefault(hashKey(x, y), 0);
        if(x > 1) {
            for(int i = 1; i < x; i++) {
                ret = Math.max(ret, dfs(i, y, map, dp) + dfs(x - i, y, map, dp));
            }
        }

        if(y > 1) {
            for(int i = 1; i < y; i++) {
                ret = Math.max(ret, dfs(x, y - i, map, dp) + dfs(x , i, map, dp));
            }
        }

        dp[x][y] = ret;
        return ret;
    }

    public int hashKey(int x, int y) {
        return x << 16 ^ y;
    }
}
