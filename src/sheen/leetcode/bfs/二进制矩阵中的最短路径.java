package sheen.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 二进制矩阵中的最短路径
 * @Date 2023/5/5 11:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        二进制矩阵中的最短路径 s = new 二进制矩阵中的最短路径();
        //System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        int[][] mat = new int[][]{{0, 1}, {1, 0}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};
        Queue<Integer> queue = new LinkedList<>();
        int len = grid[0].length;
        int end = len * grid.length - 1;
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        int res = 1;
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--!= 0) {
                int v = queue.poll();
                if(v == end) {
                    return res;
                }
                int x = v / len;
                int y = v % len;
                for(int[] m : mat) {
                    if(x + m[0] < grid.length && y + m[1] < len && x + m[0] >= 0 && y + m[1] >= 0 && grid[x + m[0]][y + m[1]] == 0) {
                        int next = (x + m[0]) * len + y + m[1];
                        if(!set.contains(next)) {
                            set.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            res++;
        }

        return -1;
    }
}
