package sheen.leetcode.DisjointSetUnion;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 统计封闭岛屿的数目
 * @Date 2023/6/18 12:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计封闭岛屿的数目 {
    public int closedIsland(int[][] grid) {
        UnionSet set = new UnionSet(grid);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    int v = i * grid[i].length + j;
                    if(i - 1 >= 0 && grid[i - 1][j] == 0) {
                        int v1 = (i - 1) * grid[i].length + j;
                        set.union(v1, v);
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 0) {
                        int v1 = i * grid[i].length + j - 1;
                        set.union(v1, v);
                    }
                }
            }
        }
        return set.getRes();
    }

    public static class UnionSet{
        private int[] arr;
        private int[][] grid;
        public UnionSet(int[][] grid) {
            int len = grid.length * grid[0].length;
            this.grid = grid;
            arr = new int[len];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        private int findRoot(int v) {
            while (arr[v] != v) {
                v = arr[v];
            }
            return v;
        }

        public void union(int a, int b) {
            int r1 = findRoot(a);
            int r2 = findRoot(b);
            arr[r1] = r2;
        }

        public int getRes() {
            int res = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    int v = i * grid[i].length + j;
                    if(grid[i][j] == 0 && arr[v] == v && check(i, j, grid, new HashSet<>())) {
                        res ++;
                    }
                }
            }
            return res;
        }

        private int[][] mat = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        public boolean check(int i, int j, int[][] grid, Set<Integer> set) {

            if(i + 1 >= grid.length || j + 1 >= grid[0].length || i - 1 < 0 ||j - 1 < 0) {
                return false;
            }

            for(int k = 0; k < mat.length; k++) {
                int nextI = i + mat[k][0];
                int nextJ = j + mat[k][1];
                int next = nextI * grid[0].length + nextJ;
                if(nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length
                        && grid[nextI][nextJ] == 0 && !set.contains(next)) {
                    set.add(next);
                    boolean flag = check(nextI, nextJ, grid, set);
                    if(!flag) {
                        return flag;
                    }
                }
            }
            return true;
        }
    }
}
