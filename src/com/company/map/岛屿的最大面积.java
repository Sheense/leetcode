package com.company.map;


public class 岛屿的最大面积 {
    public static void main(String[] args) {
        岛屿的最大面积 s = new 岛屿的最大面积();
        int[][] map = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                       {0,0,0,0,0,0,0,1,1,1,0,0,0},
                       {0,1,1,0,1,0,0,0,0,0,0,0,0},
                       {0,1,0,0,1,1,0,0,1,0,1,0,0},
                       {0,1,0,0,1,1,0,0,1,1,1,0,0},
                       {0,0,0,0,0,0,0,0,0,0,1,0,0},
                       {0,0,0,0,0,0,0,1,1,1,0,0,0},
                       {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(s.maxAreaOfIsland(map));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        boolean [][] map = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]==1&&!map[i][j]) {
                    int area = getArea(i,j,map,grid);
                    if(area>max) max = area;
                }
            }
        }
        return max;
    }
    public int getArea(int i,int j, boolean[][] map,int[][] grid) {
        if(i<0||i>=map.length) return 0;
        if(j<0||j>=map[0].length) return 0;
        if(map[i][j]) return 0;
        if(grid[i][j]==0) return 0;
        map[i][j] = true;
        return getArea(i-1,j,map,grid) + getArea(i,j-1,map,grid) + getArea(i+1,j,map,grid)+getArea(i,j+1,map,grid) + 1;
    }
}
