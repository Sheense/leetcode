package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 并行课程II
 * @Date 2023/6/16 9:36 下午
 * @Created by sheen
 * @Description TODO
 */
public class 并行课程II {
    public static void main(String[] args) {
        并行课程II s = new 并行课程II();
        System.out.println(s.minNumberOfSemesters(4, new int[][]{{2,1},{3,1},{1,4}}, 2));
    }
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] need = new int[1 << n];
        for(int i = 0; i < relations.length; i++) {
            int before = relations[i][0];
            int after = relations[i][1];
            need[1 << (after - 1)] |= 1 << (before - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < (1 << n); i++) {
            need[i] = need[i ^ (i & (-i))] | need[i & (-i)];
            if((need[i] | i) != i) {
                continue;
            }
            int study = need[i] ^ i;
            if(Integer.bitCount(study) <= k) {
                dp[i] = dp[i ^ study] + 1;
            }else {
                for(int state = study; state > 0; state = (state - 1) & study) {
                    if(Integer.bitCount(state) <= k) {
                        dp[i] = Math.min(dp[i], dp[i ^ state] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
