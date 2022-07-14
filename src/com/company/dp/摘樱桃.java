package com.company.dp;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * @Classname 摘樱桃
 * @Date 2022/7/10 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 摘樱桃 {
    public static void main(String[] args) {
        摘樱桃 s = new 摘樱桃();
        System.out.println(s.cherryPickup(new int[][]
                {{1,1,1,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0},{0,0,0,1,1,1,1}}));
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length * 2 - 1][grid.length][grid.length];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for(int k = 1; k < dp.length; k++) {
            for(int i = Math.max(k - grid.length + 1, 0); i <= Math.min(k, grid.length - 1); i++) {
                if(grid[i][k - i] == -1) {
                    continue;
                }
                for(int j = i; j <=  Math.min(k, grid.length - 1); j++) {
                    if(grid[j][k - j] == -1){
                        continue;
                    }

                    int res = dp[k - 1][i][j];
                    if(i - 1 >= 0) {
                        res = Math.max(dp[k - 1][i - 1][j], res);
                    }

                    if(j - 1 >= 0) {
                        res = Math.max(dp[k - 1][i][j - 1], res);
                    }


                    if(i - 1 >= 0 && j - 1 >= 0){
                        res = Math.max(dp[k - 1][i-1][j-1], res);
                    }

                    res += grid[i][k - i];
                    if(i != j) {
                        res += grid[j][k - j];
                    }
                    dp[k][i][j] = res;
                }
            }
        }
        return Math.max(dp[dp.length - 1][grid.length - 1][grid.length - 1], 0);
    }

}
