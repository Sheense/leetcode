package com.company.dfs;

import java.util.*;

/**
 * @Classname 喧闹和富有
 * @Date 2021/12/15 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 喧闹和富有 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < richer.length; i++) {
            map.computeIfAbsent(richer[i][1], x -> new ArrayList<>()).add(richer[i][0]);
        }
        int[] ans = new int[quiet.length];

        Map<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < quiet.length; i++) {
            ans[i] = dfs(map, quiet, i, cache);
        }

        return ans;
    }

    public int dfs(Map<Integer, List<Integer>> map, int[] quiet, int next, Map<Integer, Integer> cache) {
        if(!map.containsKey(next)) {
            return next;
        }

        if(cache.containsKey(next)) {
            return cache.get(next);
        }

        List<Integer> list = map.get(next);
        int res = next;
        for(int n : list) {
            int index = dfs(map, quiet, n, cache);
            if(quiet[index] < quiet[res]) {
                res = index;
            }
        }

        cache.put(next, res);
        return res;
    }
}
