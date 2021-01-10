package com.company.math;

public class 三维形体的表面积 {
    public static void main(String[] args) {
        三维形体的表面积 s = new 三维形体的表面积();
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(s.surfaceArea(grid));
    }
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0) {
                    int value = 2 + grid[i][j]*4;
                    if(i-1>=0) value -= (grid[i-1][j]>=grid[i][j]?grid[i][j]:grid[i-1][j]);
                    if(j-1>=0) value -= (grid[i][j-1]>=grid[i][j]?grid[i][j]:grid[i][j-1]);
                    if(i+1<grid.length) value -= (grid[i+1][j]>=grid[i][j]?grid[i][j]:grid[i+1][j]);
                    if(j+1<grid[i].length) value -=  (grid[i][j+1]>=grid[i][j]?grid[i][j]:grid[i][j+1]);
                    res += value;
                }
            }
        }
        return res;
    }
}
