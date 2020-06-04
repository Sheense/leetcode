package com.company.array;

public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int[] res = new int[matrix.length*matrix[0].length];
        int x=0;
        int y=0;
        int index = 0;
        boolean [][] map = new boolean[matrix.length][matrix[0].length];
        while(true) {
            while(y<matrix[x].length&&!map[x][y]) {
                res[index++] = matrix[x][y];
                map[x][y]=true;
                y++;
            }
            y--;
            x++;
            while(x<matrix.length&&!map[x][y]) {
                res[index++] = matrix[x][y];
                map[x][y]=true;
                x++;
            }
            x--;
            y--;
            while (y>=0&&!map[x][y]) {
                res[index++] = matrix[x][y];
                map[x][y]=true;
                y--;
            }
            y++;
            x--;
            while(x>=0&&!map[x][y]) {
                res[index++] = matrix[x][y];
                map[x][y]=true;
                x--;
            }
            x++;
            y++;
            if(index>=matrix.length*matrix[0].length) break;
        }
        return res;
    }
}
