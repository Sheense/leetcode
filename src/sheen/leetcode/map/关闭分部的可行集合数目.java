package sheen.leetcode.map;

import java.util.Arrays;

/**
 * @Classname 关闭分部的可行集合数目
 * @Date 2024/7/17 01:02
 * @Created by sheen
 * @Description TODO
 */
public class 关闭分部的可行集合数目 {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        boolean[] open = new boolean[n];
        int[][] dp = new int[n][n];
        int res = 0;
        for(int mask = 0; mask < (1 << n) - 1; mask++) {
            for(int i = 0; i < n; i++) {
                if(((1 << i) & mask) != 0) {
                    open[i] = true;
                }
            }

            for(int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], 1000000);
                dp[i][i] = 0;
            }

            for(int[] item : roads) {
                int i = item[0];
                int j = item[1];
                int len = item[2];
                if(open[i] && open[j]) {
                    dp[i][j] = Math.min(dp[i][j], len);
                    dp[j][i] = Math.min(dp[j][i], len);
                }
            }

            for(int i = 0; i < n; i++) {
                if(open[i]) {
                    for(int j = 0; j < n; j++) {
                        if(open[j]) {
                            for(int z = j + 1; z < n; z++) {
                                if(open[z]) {
                                    dp[z][j] = dp[j][z] = Math.min(dp[j][i] + dp[i][z], dp[j][z]);
                                }
                            }
                        }
                    }
                }
            }
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                if(open[i]) {
                    for(int j = i + 1; j < n; j++) {
                        if(open[j]) {
                            if(dp[i][j] > maxDistance) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if(!flag) break;
            }

            if(flag) res++;


            open = new boolean[n];
        }

        return res;
    }
}
