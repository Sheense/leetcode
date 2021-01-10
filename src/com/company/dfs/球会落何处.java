package com.company.dfs;

public class 球会落何处 {
    public int[] findBall(int[][] grid) {
        int [] res =new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++) {
            res[i] = go(grid, 0, i);
        }
        return res;
    }

    public int go(int[][] grid, int x, int y){
        if(x==grid.length) return y;
        if(grid[x][y]==1&&y==grid[0].length-1) {
            return -1;
        }
        if(y==0&&grid[x][y]==-1) {
            return -1;
        }
        if(grid[x][y]==1&&grid[x][y+1]==-1 ) {
            return -1;
        }
        if(grid[x][y]==-1&&grid[x][y-1]==1) {
            return -1;
        }
        return go(grid, x+1, y+grid[x][y]);
    }
}
