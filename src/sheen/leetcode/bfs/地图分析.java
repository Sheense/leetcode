package sheen.leetcode.bfs;

import sheen.leetcode.util.ArrayUtils;

public class 地图分析 {

    public static void main(String[] args) {
        地图分析 s = new 地图分析();
        int [][] grid = {
             {1,0,0},
                            {0,0,0},
                            {0,0,0}
        };
        System.out.println(s.maxDistance(grid));
    }
    public int maxDistance(int[][] grid) {
        int max = -1;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[i].length;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]==0) {
                    boolean[][] map = new boolean[grid.length][grid[i].length];
                    ArrayUtils.print2(dp);
                    map[i][j] = true;
                    int n = recall(grid, i, j,dp,map);
                    if(n>max) max =  n;
                }
            }
        }
        ArrayUtils.print2(dp);
        return max;
    }
    public int recall(int[][] grid, int x, int y, int[][] dp, boolean[][] map) {
        if(grid[x][y]==1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(x-1>=0&&map[x-1][y]==false) {
            map[x-1][y]=true;
            int n = dp[x-1][y]!=Integer.MAX_VALUE?dp[x-1][y]:recall(grid, x-1,y,dp, map);
            map[x-1][y]=false;
            if(n==0) {
                dp[x][y] = 1;
                return 1;
            }
            if(n!=-1) min = min>n? n:min;
        }
        if(y-1>=0&&map[x][y-1]==false) {
            map[x][y-1]=true;
            int n = dp[x][y-1]!=Integer.MAX_VALUE?dp[x][y-1]:recall(grid, x,y-1,dp,map);
            map[x][y-1]=false;
            if(n==0) {
                dp[x][y] = 1;
                return 1;
            }
            if(n!=-1) min = min>n?n:min;
        }

        if(x+1<grid.length&&map[x+1][y]==false) {
            map[x+1][y]=true;
            int n = dp[x+1][y]!=Integer.MAX_VALUE?dp[x+1][y]:recall(grid, x+1,y,dp,map);
            map[x+1][y]=false;
            if(n==0) {
                dp[x][y] = 1;
                return 1;
            }
            if(n!=-1) min = min>n?n:min;
        }
        if(y+1<grid[x].length&&map[x][y+1]==false) {
            map[x][y+1]=true;
            int n = dp[x][y+1]!=Integer.MAX_VALUE?dp[x][y+1]:recall(grid, x, y+1,dp,map);
            map[x][y+1]=false;
            if(n==0) {
                dp[x][y] = 1;
                return 1;
            }
            if(n!=-1) min = min>n?n:min;
        }
        dp[x][y]=min==Integer.MAX_VALUE?-1:min+1;
        return dp[x][y];
    }
}
