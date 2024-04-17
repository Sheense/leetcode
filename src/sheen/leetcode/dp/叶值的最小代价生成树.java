package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 叶值的最小代价生成树
 * @Date 2023/5/31 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 叶值的最小代价生成树 {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
        }

        int[][] max = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            dp[i][i] = 0;
            max[i][i] = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                max[j][i] = Math.max(arr[j], max[j + 1][i]);
                for(int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i] + max[j][k] * max[k + 1][i]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }


}
