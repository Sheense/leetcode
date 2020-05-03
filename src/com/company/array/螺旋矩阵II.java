package com.company.array;

import com.company.util.ArrayUtils;

public class 螺旋矩阵II {

    public static void main(String[] args) {
        螺旋矩阵II s = new 螺旋矩阵II();
        ArrayUtils.print2(s.generateMatrix(4));
    }
    public int[][] generateMatrix(int n) {
        int [][] map = new int[n][n];
        int x=0;
        int y=0;
        int num = 1;
        while(true) {
            while(y<n&&map[x][y]==0) {
                map[x][y] = num;
                num++;
                y++;
            }
            y--;
            x++;
            while(x<n&&map[x][y]==0) {
                map[x][y] = num;
                num++;
                x++;
            }
            x--;
            y--;
            while (y>=0&&map[x][y]==0) {
                map[x][y] = num;
                num++;
                y--;
            }
            y++;
            x--;
            while(x>=0&&map[x][y]==0) {
                map[x][y] = num;
                num++;
                x--;
            }
            x++;
            y++;
            if(num>n*n) break;
        }
        return map;
    }
}
