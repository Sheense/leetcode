package com.company.array;

import com.company.util.ArrayUtils;

public class 元素和为目标值的子矩阵数量 {
    public static void main(String[] args) {
        元素和为目标值的子矩阵数量 s = new 元素和为目标值的子矩阵数量();
        System.out.println(s.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}},0));
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(j != 0) {
                    matrix[i][j] += matrix[i][j-1];
                }
                if (i == 0) {
                    copy[i][j] = matrix[i][j];
                } else {
                    copy[i][j] = matrix[i][j] + copy[i-1][j];
                }
            }
        }
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                for(int a = 0; a <= i; a++) {
                    for(int b = 0; b <= j; b++) {
                        if (a == i && b != j) {
                            if(copy[i][j] - copy[i][b] == target) res ++;
                        } else if(b == j && a != i) {
                            if(copy[i][j] - copy[a][j] == target) res++;
                        } else if(a == i && b == j) {
                            if(copy[i][j] == target) res ++;
                        } else{
                            if(copy[i][j] - (copy[a][j] + copy[i][b] - copy[a][b]) == target) res ++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
