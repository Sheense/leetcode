package sheen.leetcode.unknow;

import sheen.leetcode.util.ArrayUtils;

public class 矩阵置零 {

    public static void main(String[] args) {
        矩阵置零 s = new 矩阵置零();
        int [][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        s.setZeroes(matrix);
        ArrayUtils.print2(matrix);
    }
    public void setZeroes(int[][] matrix) {
        int minValue = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==0) {
                    for(int x=0;x<matrix.length;x++) {
                        if(matrix[x][j]==0&&x!=i) break;
                        matrix[x][j] = minValue;
                    }
                    for(int x=0;x<matrix[0].length;x++){
                        if(matrix[i][x]==0&&x!=j) break;
                        matrix[i][x] = minValue;
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == minValue) matrix[i][j] = 0;
            }
        }
    }
}
