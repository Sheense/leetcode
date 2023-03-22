package sheen.leetcode.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 最短的桥
 * @Date 2022/10/25 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最短的桥 {
    public static void main(String[] args) {
        最短的桥 s = new 最短的桥();
        System.out.println(s.shortestBridge(new int[][]
                {{0,1,0},{0,0,0},{0,0,1}}));
    }
    private static int[][] map = new int[][]{{0,1}, {1, 0}, {-1, 0} , {0, -1}};
    public int shortestBridge(int[][] grid) {
        boolean[][] check = new boolean[grid.length][grid[0].length];
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!check[i][j] && grid[i][j] == 1) {
                    if(set1 == null) {
                        set1 = recall(i, j, check, grid);
                    }else {
                        set2 = recall(i, j, check, grid);
                    }
                }
            }
        }

        int len = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int v : set1) {
            int x = v / len;
            int y = v % len;
            for(int i = 0; i < map.length; i++) {
                int x1 = x + map[i][0];
                int y1 = y + map[i][1];
                if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == 0 && !check[x1][y1]) {
                    check[x1][y1] = true;
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] item = queue.poll();

                for(int i = 0; i < map.length; i++) {
                    int x = item[0] + map[i][0];
                    int y = item[1] + map[i][1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        int v = x * len  + y;
                        if(set2.contains(v)) {
                            return res;
                        }
                        if(grid[x][y] == 0 && !check[x][y]) {
                            check[x][y] = true;
                            queue.offer(new int[]{x, y});
                        }

                    }
                }
            }
            res++;
        }
        return 0;
    }

    public Set<Integer> recall(int x, int y, boolean[][] check, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int len = check[0].length;
        check[x][y] = true;
        set.add(x * len + y);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int[] item = queue.poll();
                for(int i = 0; i < map.length; i++) {
                    int x1 = item[0] + map[i][0];
                    int y1 = item[1] + map[i][1];
                    if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && !check[x1][y1] && grid[x1][y1] == 1) {
                        check[x1][y1] = true;
                        set.add(x1 * len + y1);
                        queue.offer(new int[]{x1, y1});
                    }
                }
            }
        }
        return set;
    }
}
