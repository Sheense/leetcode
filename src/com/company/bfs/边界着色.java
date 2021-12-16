package com.company.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname 边界着色
 * @Date 2021/12/7 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 边界着色 {
    public static void main(String[] args) {

    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int start = row * grid[0].length + col;
        int startColor = grid[row][col];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] check = new boolean[grid.length][grid[0].length];
        List<Integer> bound = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int v = queue.poll();
                int r = v / grid[0].length;
                int c = v % grid[0].length;
                check[r][c] = true;
                if(r - 1 < 0 || c - 1 < 0 || r + 1 >= grid.length || c + 1 >= grid[0].length ||
                        grid[r-1][c] != startColor || grid[r+1][c] != startColor || grid[r][c - 1] != startColor || grid[r][c+1] != startColor){
                    bound.add(v);
                }

                if(r - 1 >= 0 && !check[r - 1][c] && grid[r - 1][c] == startColor) {
                    queue.offer((r-1)*grid[0].length + c);
                }

                if(r + 1 < grid.length && !check[r + 1][c] && grid[r + 1][c] == startColor) {
                    queue.offer((r+1)*grid[0].length + c);
                }

                if(c + 1 < grid[0].length && !check[r][c + 1] && grid[r][c + 1] == startColor) {
                    queue.offer(r*grid[0].length + c + 1);
                }

                if(c - 1 >= 0 && !check[r][c - 1] && grid[r][c - 1] == startColor) {
                    queue.offer(r * grid[0].length + c - 1);
                }
            }
        }

        for(int v : bound) {
            int r = v / grid[0].length;
            int c = v % grid[0].length;
            grid[r][c] = color;
        }

        return grid;
    }
}
