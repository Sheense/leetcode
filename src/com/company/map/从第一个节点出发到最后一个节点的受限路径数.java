package com.company.map;

import com.company.util.ArrayUtils;

import java.util.*;
//dijkstra求各个点到结尾点的最短路径，dj[i,j] = Math.min(dj[i,j] , dj[k,j] + edge[i][k])
public class 从第一个节点出发到最后一个节点的受限路径数 {
    public static void main(String[] args) {
        从第一个节点出发到最后一个节点的受限路径数 s = new 从第一个节点出发到最后一个节点的受限路径数();
        System.out.println(s.countRestrictedPaths(5, new int[][]{{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}}));
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        int MAX_VALUE = Integer.MAX_VALUE - 200000;
        Map<Integer, Map<Integer, Integer>> hash = new HashMap<>();
        for(int i=0;i<edges.length;i++) {
            hash.computeIfAbsent(edges[i][0]-1, x -> new HashMap<>()).put(edges[i][1]-1, edges[i][2]);
            hash.computeIfAbsent(edges[i][1]-1, x -> new HashMap<>()).put(edges[i][0]-1, edges[i][2]);
        }
        boolean[] view = new boolean[n];
        int dj[] = new int[n];
        for(int i=0;i<dj.length-1;i++) {
            dj[i] = MAX_VALUE;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> dj[o1] - dj[o2]);
        queue.offer(n-1);
        while(!queue.isEmpty()) {
            int next = queue.poll();
            //有可能已经算出最短了，队列中有两个相同的key
            if(view[next]) continue;
            view[next] = true;
            Map<Integer, Integer> m = hash.getOrDefault(next, Collections.emptyMap());
            for(int key:m.keySet()){
                if(!view[key]) {
                    dj[key] = Math.min(dj[next] + m.get(key), dj[key]);
                    queue.offer(key);
                }
            }
        }
        return dfs(0, n-1, dj, hash, new Long[n]);
    }
    private static final int MOD = (int)Math.pow(10, 9) + 7;
    public int dfs(int start, int end, int[] arr, Map<Integer, Map<Integer, Integer>> hash, Long cnt[])  {
        if(start == end) return 1;
        if (cnt[start] != null) return (int)((long)cnt[start]);
        long res = 0;
        Map<Integer, Integer> map = hash.get(start);
        for(int key: map.keySet()) {
            if(arr[start]>arr[key]) {
                res += dfs(key, end, arr, hash, cnt);
                res %= MOD;
            }
        }
        cnt[start] = res;
        return (int)res;
    }




}
