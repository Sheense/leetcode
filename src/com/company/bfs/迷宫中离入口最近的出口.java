package com.company.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 迷宫中离入口最近的出口 {
    public static void main(String[] args) {
        迷宫中离入口最近的出口 s = new 迷宫中离入口最近的出口();
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int len = maze[0].length;
        int now = entrance[0] * len + entrance[1];
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        Set<Integer> set = new HashSet<>();
        queue.add(now);
        set.add(now);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int num = queue.poll();
                set.add(num);
                int row = num / len;
                int column = num % len;
                if((row - 1 < 0 || row + 1 >= maze.length || column - 1 < 0 || column + 1 >= len) && res != 0) {
                    return res+1;
                }

                if(row-1>=0) {
                    int item = (row-1) * len + column;
                    if(!set.contains(item) && maze[row-1][column] != '+') {
                        queue.offer(item);
                        set.add(item);
                    }
                }

                if(row + 1 < maze.length) {
                    int item = (row+1) * len + column;
                    if(!set.contains(item) && maze[row=1][column] != '+') {
                        queue.offer(item);
                        set.add(item);
                    }
                }

                if(column-1>=0) {
                    int item = row * len + column - 1;
                    if(!set.contains(item) && maze[row][column-1] != '+') {
                        queue.offer(item);
                        set.add(item);
                    }
                }

                if(column + 1 < len){
                    int item = row * len + column + 1;
                    if(!set.contains(item) && maze[row][column+1] != '+') {
                        queue.offer(item);
                        set.add(item);
                    }
                }
            }
            res ++;
        }
        return -1;
    }
}
