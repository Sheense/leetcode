package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname 连通两组点的最小成本
 * @Date 2023/6/20 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 连通两组点的最小成本 {
    public static void main(String[] args) {
        连通两组点的最小成本 s = new 连通两组点的最小成本();
        System.out.println(s.connectTwoGroups(Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(4, 1, 1), Arrays.asList(1, 5, 3))));
    }
    public int connectTwoGroups(List<List<Integer>> cost) {
        int n = cost.size();
        int m = cost.get(0).size();
        int[][] dp = new int[n + 1][1 << m];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                for(int k = 0; k < m; k++) {
                    if(((1 << k) & j) == 0) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], cost.get(i - 1).get(k) + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost.get(i - 1).get(k) + dp[i - 1][j ^ (1 << k)]);
                    dp[i][j] = Math.min(dp[i][j], cost.get(i - 1).get(k) + dp[i][j ^ (1 << k)]);
                }
            }
        }

        return dp[n][(1 << m) - 1];
    }
}
