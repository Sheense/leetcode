package com.company.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 矩阵中最大的三个菱形和 {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!set.contains(grid[i][j])) {
                    queue.add(grid[i][j]);
                    set.add(grid[i][j]);
                }
                int len = 3;
                while (i + len - 1< grid.length && j - (len - 1)/2>=0 && j + (len-1)/2<grid[i].length){
                    int n = (len - 1) /2;
                    int item = 0;
                    int x = i;
                    int y = j;
                    int q = n;
                    while (q--!=0) {
                        x++;
                        y--;
                        item += grid[x][y];
                    }
                    q = n;
                    while (q--!=0) {
                        x++;
                        y++;
                        item+=grid[x][y];
                    }
                    q = n;
                    while (q--!=0) {
                        x--;
                        y++;
                        item+= grid[x][y];
                    }
                    q = n;
                    while (q--!=0) {
                        x--;
                        y--;
                        item+= grid[x][y];
                    }
                    if(!set.contains(item)) {
                        queue.add(item);
                        set.add(item);
                    }
                    len+=2;
                }
            }
        }
        if(queue.size() >= 3) {
           int[] res = new int[3];
           for(int i =0;i<res.length;i++) {
               res[i] = queue.poll();
           }
           return res;
        }else {
           int[] res = new int[queue.size()];
           for (int i = 0;i < res.length; i++) {
               res[i] = queue.poll();
           }
           return res;
        }
    }
}
