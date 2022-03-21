package com.company.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 重构一棵树的方案数
 * @Date 2022/2/16 1:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重构一棵树的方案数 {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i = 0; i < pairs.length; i++) {
            adj.computeIfAbsent(pairs[i][0], x -> new HashSet<>()).add(pairs[i][1]);
            adj.computeIfAbsent(pairs[i][1], x -> new HashSet<>()).add(pairs[i][0]);
        }

        int root = -1;
        for(int key : adj.keySet()) {
            if(adj.get(key).size() == adj.size() - 1) {
                root = key;
            }
        }
        if(root == -1) {
            return 0;
        }

        int res = 1;
        for(int key : adj.keySet()) {
            if(key == root) {
                continue;
            }

            Set<Integer> neighbours = adj.get(key);
            int curCount = neighbours.size();
            int parent = -1;
            int parentCount = Integer.MAX_VALUE;
            for(int neighbour : neighbours) {
                if(adj.get(neighbour).size() >= curCount && parentCount > adj.get(neighbour).size()) {
                    parent = neighbour;
                    parentCount = adj.get(neighbour).size();
                }
            }

            if(parent == -1) {
                return 0;
            }

            for(int neighbour : neighbours) {
                if(neighbour == parent) {
                    continue;
                }else if(!adj.get(parent).contains(neighbour)) {
                    return 0;
                }
            }

            if (parentCount == curCount) {
                res = 2;
            }
        }
        return res;
    }
}
