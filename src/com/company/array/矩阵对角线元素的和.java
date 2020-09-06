package com.company.array;

public class 矩阵对角线元素的和 {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int start = 0;
        int end = mat[0].length-1;
        for(int i=0;i<mat.length;i++) {
            if(start!=end) {
                res +=(mat[i][start]+mat[i][end]);
            }else {
                res += mat[i][start];
            }
            start++;
            end--;
        }
        return res;
    }
}
