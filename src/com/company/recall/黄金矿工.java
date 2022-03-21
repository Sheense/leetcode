package com.company.recall;

/**
 * @Classname 黄金矿工
 * @Date 2022/2/5 5:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 黄金矿工 {

    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    res = Math.max(res, recall(grid, i ,j , new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return res;
    }
    private static int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
    public int recall(int[][] grid, int x, int y, boolean[][] check) {
        int res = 0;
        check[x][y] = true;
        for(int i = 0; i < next.length; i++) {
            int a = x + next[i][0];
            int b = y + next[i][1];
            if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && !check[a][b] && grid[a][b] > 0) {
                res = Math.max(res, recall(grid, a, b, check));
            }
        }

        check[x][y] = false;
        return res + grid[x][y];
    }
}
