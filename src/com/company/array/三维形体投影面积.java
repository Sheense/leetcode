package com.company.array;

/**
 * @Classname 三维形体投影面积
 * @Date 2022/4/26 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 三维形体投影面积 {
    public int projectionArea(int[][] grid) {
        int res = 0;
        int maxLen = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            int max = 0;
            maxLen = Math.max(maxLen, grid[i].length);
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    res++;
                }
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        for(int j = 0; j < maxLen; j++) {
            int max = 0;
            for(int i = 0; i < grid.length; i++) {
                int v = j < grid[i].length ? grid[i][j] : 0;
                max = Math.max(v, max);
            }
            res += max;
        }
        return res;
    }
}
