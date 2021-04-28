package com.company.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 水域大小 {

    int[][] direct = new int[][]{{1,0},{-1,0},{0,1},{0, -1},
            {1,1},{1,-1},{-1,1},{-1,-1}};
    public int[] pondSizes(int[][] land) {

        boolean[][] map = new boolean[land.length][land[0].length];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<land.length;i++) {
            for(int j=0;j<land[i].length;j++) {
                if(land[i][j] == 0 && !map[i][j]){
                    res.add(dfs(i, j, map, land));
                }
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
    public int dfs(int x, int y, boolean[][] map, int[][] land) {
        if(x<0 || y <0 || x>=land.length || y>= land[0].length) return 0;
        if(land[x][y] > 0 || map[x][y]) return 0;
        int res = 1;
        map[x][y] = true;
        for(int i=0;i<direct.length;i++) {
            res += dfs(x + direct[i][0], y + direct[i][1], map, land);
        }
        return res;
    }
}
