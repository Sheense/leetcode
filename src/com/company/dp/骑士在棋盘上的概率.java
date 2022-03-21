package com.company.dp;

/**
 * @Classname 骑士在棋盘上的概率
 * @Date 2022/2/17 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 骑士在棋盘上的概率 {
    private static final int[][] mat = new int[][]{{1, 2}, {2 , 1}, {-2, -1}, {-1, -2}, {-2, 1}, {1, -2}, {2, -1}, {-1, 2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for(int i = 0; i <= k; i++) {
            for(int j = 0; j < n; j++) {
                for(int z = 0; z < n; z++) {
                    if(i == 0) {
                        dp[i][j][z] = 1;
                    }else {
                        for(int[] m : mat) {
                            int x = j + m[0];
                            int y = z + m[1];
                            if(x >= 0 && x < n && y >= 0 && y < n) {
                                dp[i][j][z] += dp[i-1][x][y] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
