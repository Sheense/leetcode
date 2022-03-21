package com.company.bfs;

import com.company.util.ArrayUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 地图中的最高点
 * @Date 2022/1/29 12:46 下午
 * @Created by sheen
 * @Description TODO
 */
public class 地图中的最高点 {
    public static void main(String[] args) {
        地图中的最高点 s = new 地图中的最高点();
        ArrayUtils.print2(s.highestPeak(new int[][]{{0,0,1},{1,0,0},{0,0,0}}));
    }
    public int[][] highestPeak(int[][] isWater) {
        int[][] mat = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[isWater.length][isWater[0].length];
        int len = isWater[0].length;
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < isWater.length; i++) {
            for(int j = 0; j < isWater[0].length; j++) {
                if(isWater[i][j] == 1) {
                    set.add(i * len + j);
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int now = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --!=0 ) {
                int[] point = queue.poll();
                res[point[0]][point[1]] = now;
                for(int i = 0; i < mat.length; i++) {
                    int x = point[0] + mat[i][0];
                    int y = point[1] + mat[i][1];
                    if(x >= 0 && x < isWater.length && y >= 0 && y < isWater[0].length && !set.contains(x * len + y)) {
                        set.add(x * len + y);
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            now++;
        }

        return res;
    }
}
