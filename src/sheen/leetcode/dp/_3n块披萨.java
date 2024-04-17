package sheen.leetcode.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Classname _3n块披萨
 * @Date 2023/8/18 01:09
 * @Created by sheen
 * @Description TODO
 */
public class _3n块披萨 {
    public int maxSizeSlices(int[] slices) {
        int[] v1 = new int[slices.length - 1];
        int[] v2 = new int[slices.length - 1];
        int j = 0;
        int z = 0;
        for(int i = 0; i < slices.length; i++) {
            if(i == 0) {
                v1[j++] = slices[i];
            }else if(i == slices.length - 1) {
                v2[z++] = slices[i];
            }else {
                v1[j++] = slices[i];
                v2[z++] = slices[i];
            }
        }
        int a = getMax(v1, slices.length / 3);
        int b = getMax(v2, slices.length / 3);

        return Math.max(a, b);
    }

    public int getMax(int[] v, int target) {
        int[][] dp = new int[v.length][target + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = 0;
        dp[0][1] = v[0];
        dp[1][0] = 0;
        dp[1][1] = Math.max(v[0], v[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i][0] = 0;
            for(int j = 1; j <= target; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + v[i]);

            }
        }
        return dp[v.length - 1][target];
    }


}
