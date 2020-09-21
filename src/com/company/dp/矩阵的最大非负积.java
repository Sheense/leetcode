package com.company.dp;

import com.company.util.ArrayUtils;

public class 矩阵的最大非负积 {

    public static void main(String[] args) {
        矩阵的最大非负积 s = new 矩阵的最大非负积();
        System.out.println(s.maxProductPath(new int[][]{{  1, 4,4,0},{-2, 0,0,1},{1,-1,1,1}}));
    }
    public int maxProductPath(int[][] grid) {
        boolean hasZero = false;
        long[][] max = new long[grid.length][grid[0].length];
        long[][] min = new long[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==0) {
                    hasZero = true;
                    max[i][j] = 0;
                    min[i][j] = 0;
                    continue;
                }
                if(i==0) {
                    if(j==0) {
                        if(grid[i][j]>0) max[i][j] = grid[i][j];
                        else min[i][j] = grid[i][j];
                    }else {
                        if(grid[i][j]>0) {
                            max[i][j] = max[i][j-1]!=0?max[i][j-1]*grid[i][j]:0;
                            min[i][j] = min[i][j-1]!=0?min[i][j-1]*grid[i][j]:0;
                        }
                        else {
                            max[i][j] = min[i][j-1]!=0?min[i][j-1]*grid[i][j]:0;
                            min[i][j] = max[i][j-1]!=0?max[i][j-1]*grid[i][j]:0;
                        }
                    }
                }else {
                    if(j==0) {
                        if(grid[i][j]>0) {
                            max[i][j] = max[i-1][j]!=0?max[i-1][j]*grid[i][j]:0;
                            min[i][j] = min[i-1][j]!=0?min[i-1][j]*grid[i][j]:0;
                        }
                        else {
                            max[i][j] = min[i-1][j]!=0?min[i-1][j]*grid[i][j]:0;
                            min[i][j] = max[i-1][j]!=0?max[i-1][j]*grid[i][j]:0;
                        }
                    }else {
                        if(grid[i][j]>0) {
                            max[i][j] = Math.max(max[i-1][j],max[i][j-1])*grid[i][j];
                            min[i][j] = Math.min(min[i-1][j],min[i][j-1])*grid[i][j];
                        }
                        else {
                            max[i][j] = Math.min(min[i-1][j],min[i][j-1])*grid[i][j];
                            min[i][j] = Math.max(max[i-1][j],max[i][j-1])*grid[i][j];
                        }
                    }
                }
            }
        }
        if(max[grid.length-1][grid[0].length-1]==0) {
            if(hasZero) return 0;
            return -1;
        }
        return (int)(max[grid.length-1][grid[0].length-1]%(Math.pow(10,9)+7));
    }


}
