package com.company.array;

import com.company.util.ArrayUtils;

import java.time.chrono.MinguoDate;

public class 最大的幻方 {
    public static void main(String[] args) {
        最大的幻方 s = new 最大的幻方();
        System.out.println(s.largestMagicSquare(new int[][]{{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}}));
    }
    public int largestMagicSquare(int[][] grid) {
        int maxLen = Math.min(grid.length, grid[0].length);
        int[][] height = new int[grid.length][grid[0].length];
        int[][] width = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j ++) {
                width[i][j] = grid[i][j];
                height[i][j] = grid[i][j];
                if (i - 1 >= 0) {
                    height[i][j] += height[i-1][j];
                }
                if (j - 1 >= 0) {
                    width[i][j] += width[i][j-1];
                }
            }
        }
        int res = 1;
        for (int k = 2; k <= maxLen; k ++) {
            for (int i = 0; i <= grid.length - k; i++) {
                for (int j = k - 1; j < grid[i].length; j ++) {
                    if(check(i, j, k, height, width, grid)) {
                        res = k;
                    }
                }
            }
        }
        return res;
    }

    public boolean check(int i, int j, int k, int[][] height, int[][] width, int[][] grid) {
        int index = 1;
        int h = j - k >= 0 ? width[i][j] - width[i][j - k] : width[i][j];
        int w = i == 0 ? height[i+k-1][j] : height[i+k-1][j] - height[i-1][j];
        if(h != w) return false;
        int item = h;
        int y = j;
        int x = i;
        while (index < k) {
            int itemH = j - k >= 0 ? width[x][j] - width[x][j - k] : width[x][j];
            int itemW = i == 0 ? height[i+k-1][y] : height[i+k-1][y] - height[i-1][y];
            if (itemH != itemW || itemH != item) {
                return false;
            }
            x++;
            y--;
            index ++;
        }
        index = 0;
        int leftX = i;
        int leftY = j - k + 1;
        int rightX = i;
        int rightY = j;
        int sumLeft = 0;
        int sumRight = 0;
        while (index++ < k) {
            sumLeft += grid[leftX++][leftY++];
            sumRight += grid[rightX++][rightY--];
        }
        if(sumLeft!=sumRight || sumLeft != item) return false;
        return true;
    }
}
