package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 穿过迷宫的最少移动次数
 * @Date 2023/2/5 6:02 下午
 * @Created by sheen
 * @Description TODO
 */
public class 穿过迷宫的最少移动次数 {
    public static void main(String[] args) {
        穿过迷宫的最少移动次数 s = new 穿过迷宫的最少移动次数();
        System.out.println(s.minimumMoves(new int[][]{{0,0,0,0,0,1},
                                                      {1,1,0,0,1,0},
                                                      {0,0,0,0,1,1},
                                                      {0,0,1,0,1,0},
                                                      {0,1,1,0,0,0},
                                                      {0,1,1,0,0,0}}));
    }
    public int minimumMoves(int[][] grid) {
        boolean[][][] fill = new boolean[grid.length][grid[0].length][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                int status = point[2];
                if(status == 0) {
                    if(y + 2 < grid[0].length && grid[x][y + 2] == 0 && !fill[x][y + 1][0]) {
                        fill[x][y + 1][0] = true;
                        queue.offer(new int[]{x, y + 1, 0});
                    }

                    if(x + 1 < grid.length && y + 1 < grid[0].length && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && !fill[x + 1][y][0]) {
                        fill[x + 1][y][0] = true;
                        queue.offer(new int[]{x + 1, y, 0});
                    }

                    if(x + 1 < grid.length && y + 1 < grid[0].length && grid[x + 1][y] == 0 && !fill[x][y][1] && grid[x + 1][y + 1] == 0) {
                        fill[x][y][1] = true;
                        queue.offer(new int[]{x, y, 1});
                    }
                }else {

                    if(x + 2 < grid.length && grid[x + 2][y] == 0 && !fill[x + 1][y][1]) {
                        fill[x + 1][y][1] = true;
                        queue.offer(new int[]{x + 1, y, 1});
                    }

                    if(y + 1 < grid[0].length && x + 1 < grid.length && grid[x][y + 1] == 0 && !fill[x][y + 1][1] && grid[x + 1][y+1] == 0) {
                        fill[x][y + 1][1] = true;
                        queue.offer(new int[]{x, y + 1, 1});
                    }

                    if(x + 1 < grid.length && y + 1 < grid[0].length && grid[x + 1][y+1] == 0 && !fill[x][y][0] && grid[x][y+1] == 0) {
                        fill[x][y][0] = true;
                        queue.offer(new int[]{x, y, 0});
                    }
                }
            }
            res++;
            if(fill[grid.length - 1][grid[0].length - 2][0]) {
                return res;
            }
        }
        return -1;
    }


}
