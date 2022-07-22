package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class 零矩阵 {

    public static void main(String[] args) {
        零矩阵 s = new 零矩阵();
        int [][] matrix = {
                            {0,1}
        };
        s.setZeroes(matrix);
        ArrayUtils.print2(matrix);
    }
    public void setZeroes(int[][] matrix) {
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j]==0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for(int value:x) {
            for(int z=0;z<matrix[0].length;z++) matrix[value][z] = 0;
        }
        for(int value:y) {
            for(int z=0;z<matrix.length;z++) matrix[z][value] = 0;
        }
    }
}
