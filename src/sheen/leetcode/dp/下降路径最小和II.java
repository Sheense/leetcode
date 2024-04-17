package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 下降路径最小和II
 * @Date 2023/8/10 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 下降路径最小和II {
    public static void main(String[] args) {
        下降路径最小和II s = new 下降路径最小和II();
        System.out.println(s.minFallingPathSum(new int[][]{{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2}}
));
    }
    public int minFallingPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            if(i == 0) {
                for(int j = 0; j < grid[0].length; j++) {
                    dp[j] = grid[i][j];
                }
            }else {
                int[] next = new int[dp.length];
                for(int j = 0; j < dp.length; j++) {
                    int min = Integer.MAX_VALUE;
                    for(int z = 0; z < dp.length; z++) {
                        if(z != j) {
                            min = Math.min(min, dp[z]);
                        }
                    }
                    if(min == Integer.MAX_VALUE) {
                        next[j] = min;
                    }else {
                        next[j] = min + grid[i][j];
                    }
                }
                dp = next;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < dp.length; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
