package com.company.bfs;

import java.util.*;

public class 统计子岛屿 {

    public static void main(String[] args) {
        统计子岛屿 s = new 统计子岛屿();
        System.out.println(s.countSubIslands(new
                int[][]{{1,1,1,1,0,0},
                        {1,1,0,1,0,0},
                        {1,0,0,1,1,1},
                        {1,1,1,0,0,1},
                        {1,1,1,1,1,0},
                        {1,0,1,0,1,0},
                        {0,1,1,1,0,1},
                        {1,0,0,0,1,1},
                        {1,0,0,0,1,0},
                        {1,1,1,1,1,0}},
                new int[][]{{1,1,1,1,0,1},
                            {0,0,1,0,1,0},
                            {1,1,1,1,1,1},
                            {0,1,1,1,1,1},
                            {1,1,1,0,1,0},
                            {0,1,1,1,1,1},
                            {1,1,0,1,1,1},
                            {1,0,0,1,0,1},
                            {1,1,1,1,1,1},
                            {1,0,0,1,0,0}}));
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        List<Set<Integer>> l = findLands(grid2);
        int res = 0;
        for(Set<Integer> s : l) {
            boolean flag = true;
            for(int value : s) {
                if(grid1[value/grid1[0].length][value % grid1[0].length] == 0) {
                    flag = false;
                }
            }
            if(flag) res ++;
        }
        return res;
    }

    public List<Set<Integer>> findLands(int[][] grid) {
        List<Set<Integer>> res = new ArrayList<>();
        boolean[][] map = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++) {
            for(int j =0;j<grid[0].length;j++) {
                if(grid[i][j]==1 && !map[i][j]) {
                    res.add(bfs(i,j,grid,map));
                }
            }
        }
        return res;
    }

    public Set<Integer> bfs(int i, int j, int[][] grid, boolean[][] map) {
        Set<Integer> set = new HashSet<>();
        process(i, j, grid, map, set);
        return set;
    }

    public void process(int i, int j, int[][] grid, boolean[][] map, Set<Integer> set) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || map[i][j]) {
            return;
        }
        map[i][j] = true;
        set.add(i*grid[0].length + j);
        process(i-1, j, grid, map, set);
        process(i, j-1, grid, map, set);
        process(i+1, j, grid, map, set);
        process(i, j+1, grid, map, set);
    }

}
