package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 寻找图中是否存在路径
 * @Date 2022/12/19 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 寻找图中是否存在路径 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(destination == source) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(source);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(edges[i][0]);
        }

        return dfs(source, destination, set, map);
    }

    public boolean dfs(int now, int end, Set<Integer> set, Map<Integer, List<Integer>> map) {
        List<Integer> list = map.get(now);
        if(list == null) {
            return false;
        }

        for(int v : list) {
            if(v == end) {
                return true;
            }
            if(!set.contains(v)) {
                set.add(v);
                if(dfs(v, end, set, map)) {
                    return true;
                }
            }
        }

        return false;
    }
}
