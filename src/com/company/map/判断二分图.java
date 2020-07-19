package com.company.map;

import java.util.*;

public class 判断二分图 {

    public static void main(String[] args) {
        判断二分图 s = new 判断二分图();
        System.out.println(s.isBipartite(new int[][]{{1},{0,3},{3},{1,2}}));
    }
    public boolean isBipartite(int[][] graph) {
        if(graph.length==0||graph.length==1) return true;
        int[] judge = new int[graph.length];
        int index = 0;
        while(index<graph.length-1&&graph[index].length==0) {
            index++;
        }
        judge[index] = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = index;i<graph.length;i++) {
            if(!set.contains(i)) {
                if(!dfs(judge,graph,index, set)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[] judge, int[][] graph, int index, Set<Integer> set) {
        set.add(index);
        for(int i=0;i<graph[index].length;i++) {
            if(judge[graph[index][i]]==0) {
                judge[graph[index][i]]=-judge[index];
                if(!set.contains(graph[index][i])) {
                    if(!dfs(judge, graph, graph[index][i],set)) return false;
                }
            }else {
                if(judge[graph[index][i]] == judge[index]) return false;
                else{
                    if(!set.contains(graph[index][i])) {
                        if(!dfs(judge, graph, graph[index][i],set)) return false;
                    }
                }

            }
        }


        return true;
    }
}
