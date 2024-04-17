package sheen.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 不同路径III
 * @Date 2023/8/4 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 不同路径III {
    public int uniquePathsIII(int[][] grid) {
        int startI = 0;
        int startJ = 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int  j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 0) {
                    count++;
                }
                if(grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        return dfs(new HashSet<>(), startI, startJ, grid, 0, count);
    }

    private int[][] mat = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int dfs(Set<Integer> set, int i, int j, int[][] grid, int count, int target) {
        if(grid[i][j] == 2) {
            if(count == target) {
                return 1;
            }else {
                return 0;
            }
        }
        count++;
        int n = grid[0].length;
        set.add(i * n + j);
        int res = 0;
        for(int[] item : mat) {
            int x = item[0] + i;
            int y = item[1] + j;
            int v = x * n + y;
            if(x >= 0 && x < grid.length && y >= 0 && y < n && grid[x][y] != -1 && !set.contains(v)) {
                res += dfs(set, x, y, grid, count, target);
            }
        }
        set.remove(i * n + j);
        return res;
    }
}
