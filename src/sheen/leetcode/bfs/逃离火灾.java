package sheen.leetcode.bfs;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 逃离火灾
 * @Date 2023/11/9 00:43
 * @Created by sheen
 * @Description TODO
 */
public class 逃离火灾 {
    public static void main(String[] args) {
        逃离火灾 s = new 逃离火灾();
        //System.out.println(s.maximumMinutes(new int[][]{{0,0,0},{2,2,0},{1,2,0}}));
        System.out.println(s.maximumMinutes(new int[][]{{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}}));
    }
    public int maximumMinutes(int[][] grid) {
        int[][] fireTime = new int[grid.length][grid[0].length];
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int maxFireTime = 1000000000;
        for(int i = 0; i < grid.length; i++) {
            Arrays.fill(fireTime[i], maxFireTime);
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(i * n + j);
                }else if (grid[i][j] == 0) {
                    fireTime[i][j] = maxFireTime;
                }
            }
        }
        bfs(queue, fireTime, grid);

        int left = 0;
        int right = grid.length * grid[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(check(mid, fireTime, grid)) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if (left == grid.length * grid[0].length) {
            return maxFireTime;
        }
        return right;
    }

    public boolean check(int keepTime, int[][] fireTime, int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] point = queue.poll();
                visit[point[0]][point[1]] = true;
                for(int[] item : mat) {
                    int nextX = item[0] + point[0];
                    int nextY = point[1] + item[1];
                    if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                        return fireTime[nextX][nextY] >=  time + keepTime;
                    }
                    if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && grid[nextX][nextY] == 0 && fireTime[nextX][nextY] > time + keepTime && !visit[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            time++;
        }

        return false;
    }
    private int[][] mat = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void bfs(Queue<Integer> queue, int[][] fireTime, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int v = queue.poll();
                if (!set.contains(v)) {
                    set.add(v);
                    int x = v / grid[0].length;
                    int y = v % grid[0].length;
                    fireTime[x][y] = time;
                    for(int[] item : mat) {
                        int nextX = item[0] + x;
                        int nextY = y + item[1];
                        int next = nextX * grid[0].length + nextY;
                        if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                                && !set.contains(next) && grid[nextX][nextY] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
            time++;
        }
    }
}
