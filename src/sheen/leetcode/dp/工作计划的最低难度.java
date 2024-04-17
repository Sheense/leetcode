package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 工作计划的最低难度
 * @Date 2023/5/16 6:52 下午
 * @Created by sheen
 * @Description TODO
 */
public class 工作计划的最低难度 {
    public static void main(String[] args) {
        工作计划的最低难度 s = new 工作计划的最低难度();
        System.out.println(s.minDifficulty(new int[]{6,5,4,3,2,1
}, 2));
    }
    public int minDifficulty1(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d + 1][n];
        for (int i = 0; i <= d; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        int ma = 0;
        for (int i = 0; i < n; ++i) {
            ma = Math.max(ma, jobDifficulty[i]);
            dp[0][i] = ma;
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                ma = 0;
                for (int k = j; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], ma + dp[i - 1][k - 1]);
                }
            }
        }
        ArrayUtils.print2(dp);
        return dp[d - 1][n - 1];
    }


    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) {
            return -1;
        }
        int[][] dp = new int[d][jobDifficulty.length];
        for(int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1000000);
        }
        int max = 0;
        for(int i = 0; i < jobDifficulty.length; i++) {
            max = Math.max(max, jobDifficulty[i]);
            dp[0][i] = max;
        }

        for(int i = 1; i < d; i++) {
            for(int j = i; j < jobDifficulty.length; j++) {
                max = 0;
                for(int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + max);
                }
            }
        }
        ArrayUtils.print2(dp);
        return dp[d - 1][jobDifficulty.length - 1];
    }
}
