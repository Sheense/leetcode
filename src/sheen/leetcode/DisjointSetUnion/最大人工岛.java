package sheen.leetcode.DisjointSetUnion;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 最大人工岛
 * @Date 2022/9/18 10:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大人工岛 {
    public static void main(String[] args) {
        最大人工岛 s = new 最大人工岛();
        System.out.println(s.largestIsland(new int[][]{{1,1,1,1,0}, {0,0,0,0,0}, {1,1,0,1,1}, {1,1,0,1,0}}));
    }
    public int largestIsland(int[][] grid) {
        UnionSet unionSet = new UnionSet(grid);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int v = i * grid[i].length + j;
                    if(i - 1 >= 0 && grid[i-1][j] == 1) {
                        int pre = (i - 1) * grid[i].length + j;
                        unionSet.union(pre, v);
                    }

                    if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                        int pre = i * grid[i].length + j - 1;
                        unionSet.union(pre, v);
                    }
                }
            }
        }
        int res = unionSet.maxCount();
        int[][] oper = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    int count = 1;
                    Set<Integer> rootSet = new HashSet<>();
                    for(int k = 0; k < oper.length; k++) {
                        int x = i + oper[k][0];
                        int y = j + oper[k][1];
                        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                            int v = (i + oper[k][0]) * grid[0].length + (j + oper[k][1]);
                            int root = unionSet.findRoot(v);
                            if(!rootSet.contains(root)) {
                                count += unionSet.count(root);
                                rootSet.add(root);
                            }
                        }
                    }

                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public static class UnionSet{

        private int[] set;
        private int[] count;
        public UnionSet(int[][] grid) {
            int length = grid.length * grid[0].length;

            set = new int[length];
            count = new int[length];
            for(int i = 0; i < length; i++) {
                set[i] = i;
                if(grid[i / grid[0].length][i % grid[0].length] == 1) {
                    count[i] = 1;
                }
            }
        }

        public int findRoot(int v) {
            while (set[v] != v) {
                v = set[v];
            }

            return v;
        }

        public void union(int a, int b) {
            int root1 = findRoot(a);
            int root2 = findRoot(b);
            if(root1 == root2) {
                return;
            }

            while (set[b] != b) {
                int swap = set[b];
                set[b] = root1;
                b = swap;
            }

            set[b] = root1;
            count[root1] += count[b];
        }

        public int count(int a) {
            int root = findRoot(a);
            return count[root];
        }

        public int maxCount() {
            int res = 0;
            for(int i = 0; i < set.length; i++) {
                if(set[i] == i) {
                    res = Math.max(res, count[i]);
                }
            }

            return res;
        }
    }
}
