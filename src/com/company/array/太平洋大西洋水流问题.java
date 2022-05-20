package com.company.array;

import java.util.*;

/**
 * @Classname 太平洋大西洋水流问题
 * @Date 2022/4/27 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 太平洋大西洋水流问题 {
    public static void main(String[] args) {
        太平洋大西洋水流问题 s = new 太平洋大西洋水流问题();
        System.out.println(s.pacificAtlantic(new int[][]   {{8,13,11,18,14,16,16,4,4,8,10,11,1,19,7},
                {2,9,15,16,14,5,8,15,9,5,14,6,10,15,5},
                {15,16,17,10,3,6,3,4,2,17,0,12,4,1,3},
                {13,6,13,15,15,16,4,10,7,4,19,19,4,9,13},
                {7,1,9,14,9,11,5,4,15,19,6,0,0,13,5},
                {9,9,15,12,15,5,1,1,18,1,2,16,15,18,9},
                {13,0,4,18,12,0,11,0,1,15,1,15,4,2,0},
                {11,13,12,16,9,18,6,8,18,1,5,12,17,13,5},
                {7,17,2,5,0,17,9,18,4,13,6,13,7,2,1},
                {2,3,9,0,19,6,6,15,14,4,8,1,19,5,9},
                {3,10,5,11,7,14,1,5,3,19,12,5,2,13,16},
                {0,8,10,18,17,5,5,8,2,11,5,16,4,9,14},
                {15,9,16,18,9,5,2,5,13,3,10,19,9,14,3},
                {12,11,16,1,10,12,6,18,6,6,18,10,9,5,2},
                {17,9,6,6,14,9,2,2,13,13,15,17,15,3,14},
                {18,14,12,6,18,16,4,10,19,5,6,8,9,1,6}}));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pCheck = new boolean[heights.length][heights[0].length];
        boolean[][] aCheck = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[i].length; j++) {
                if(i == 0 || j == 0) {
                    if(!pCheck[i][j]) {
                        pacific[i][j] = true;
                        dfs(pCheck, heights, i, j, pacific);
                    }
                }
                if(i == heights.length - 1 || j == heights[i].length - 1) {
                    if(!aCheck[i][j]) {
                        atlantic[i][j] = true;
                        dfs(aCheck, heights, i, j, atlantic);
                    }
                }
            }
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[i].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] check, int[][] heights, int x, int y, boolean[][] res) {
        check[x][y] = true;

        if(x - 1 >= 0 && !check[x - 1][y] && heights[x - 1][y] >= heights[x][y]) {
            res[x - 1][y] = true;
            dfs(check, heights, x - 1, y, res);
        }

        if(x + 1 < heights.length && !check[x + 1][y] && heights[x + 1][y] >= heights[x][y]) {
            res[x + 1][y] = true;
            dfs(check, heights, x + 1, y, res);
        }

        if(y - 1 >= 0 && !check[x][y - 1] && heights[x][y - 1] >= heights[x][y]) {
            res[x][y - 1] = true;
            dfs(check, heights, x, y - 1, res);
        }

        if(y + 1 < heights[0].length && !check[x][y + 1] && heights[x][y + 1] >= heights[x][y]) {
            res[x][y + 1] = true;
            dfs(check, heights, x, y + 1, res);
        }
    }

    

}
