package com.company.bfs;

import java.util.*;

/**
 * @Classname 访问所有节点的最短路径
 * @Date 2021/8/6 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 访问所有节点的最短路径 {
    public static void main(String[] args) {
        访问所有节点的最短路径 s = new 访问所有节点的最短路径();
        System.out.println(s.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));
    }
    public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < graph.length; i++) {
            int mask = 1 << i;
            res |= mask;
            int disk = 0;
            int[] item = {i, mask, disk};
            queue.offer(item);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-->0) {
                int[] item = queue.poll();
                int index = item[0];
                int nowMask = item[1];
                int disk = item[2];
                if(nowMask == res) {
                    return disk;
                }
                for(int i = 0; i < graph[index].length; i++) {
                    int next = graph[index][i];
                    int nextMask = nowMask | (1 << next);
                    if(!map.getOrDefault(next, new HashSet<>()).contains(nextMask)) {
                        int[] nextItem = {next, nextMask, disk+1};
                        map.computeIfAbsent(next, x -> new HashSet<>()).add(nextMask);
                        queue.offer(nextItem);
                    }
                }
            }
        }
        return 0;
    }
}
