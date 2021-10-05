package com.company.array;

import com.company.util.ArrayUtils;

/**
 * @Classname 网格游戏
 * @Date 2021/9/26 10:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 网格游戏 {
    public static void main(String[] args) {
        网格游戏 s = new 网格游戏();
        System.out.println(s.gridGame(new int[][]{{2,5,4},{1,5,1}}));
    }
    public long gridGame(int[][] grid) {
        long[][] arr = new long[2][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(j == 0) {
                    arr[i][j] = grid[i][j];
                }else {
                    arr[i][j] = grid[i][j] + arr[i][j-1];
                }
            }
        }

        long[] second = new long[grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            if(i == 0) {
                second[0] = arr[0][grid[0].length - 1] - arr[0][0];
            }else if(i == grid[0].length - 1) {
                second[i] = arr[1][i - 1];
            }else {
                long a = arr[0][grid[0].length - 1] - arr[0][i];
                long b = arr[1][i - 1];
                second[i] = Math.max(a, b);
            }
        }
        long res = second[0];
        for(int i = 0; i < second.length; i++) {
            res = Math.min(res, second[i]);
        }
        return res;
    }

}
