package com.company.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 节点间通路 {
    public static void main(String[] args) {
        节点间通路 s = new 节点间通路();
        System.out.println(s.findWhetherExistsPath(12, new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}}, 2, 3));
    }
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<graph.length;i++) {
            map.computeIfAbsent(graph[i][0], x -> new HashSet<>()).add(graph[i][1]);
        }
        Set<Integer> set =  new HashSet<>();
        set.add(start);
        return hasPath(map, set, start, target);

    }

    public boolean hasPath(Map<Integer, Set<Integer>> map,Set<Integer> set, int start, int target) {
        Set<Integer> next = map.get(start);
        if(next == null) return false;
        for(int p : next) {
            if(!set.contains(p)) {
                if(p == target) return true;
                set.add(p);
                boolean res = hasPath(map, set, p, target);
                if(res) return res;
                set.remove(p);
            }
        }
        return false;
    }


}
