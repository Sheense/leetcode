package com.company.array;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {

    public static void main(String[] args) {
        int[][] m = {
                            {2,5},
                            { 8,4 },
                            {0,-1}
        };
        螺旋矩阵 s = new 螺旋矩阵();
        ArrayUtils.print(s.spiralOrder(m));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0) return list;
        int x=0;
        int y=0;
        int num = 1;
        boolean [][] map = new boolean[matrix.length][matrix[0].length];
        while(true) {
            while(y<matrix[x].length&&!map[x][y]) {
                list.add(matrix[x][y]);
                num++;
                map[x][y]=true;
                y++;
            }
            y--;
            x++;
            while(x<matrix.length&&!map[x][y]) {
                list.add(matrix[x][y]);
                map[x][y]=true;
                num++;
                x++;
            }
            x--;
            y--;
            while (y>=0&&!map[x][y]) {
                list.add(matrix[x][y]);
                map[x][y]=true;
                num++;
                y--;
            }
            y++;
            x--;
            while(x>=0&&!map[x][y]) {
                list.add(matrix[x][y]);
                map[x][y]=true;
                num++;
                x--;
            }
            x++;
            y++;
            if(num>matrix.length*matrix[0].length) break;
        }
        return list;
    }
}
