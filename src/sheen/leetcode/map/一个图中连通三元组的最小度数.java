package sheen.leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 一个图中连通三元组的最小度数
 * @Date 2023/8/31 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 一个图中连通三元组的最小度数 {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new HashSet<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new HashSet<>()).add(edges[i][0]);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            Set<Integer> set1 = map.getOrDefault(a, new HashSet<>());
            Set<Integer> set2 = map.getOrDefault(b, new HashSet<>());
            for(int j = 0; j < n; j++) {
                if(j != a && j != b && set1.contains(j) && set2.contains(j)) {
                    Set<Integer> set3 = map.getOrDefault(j, new HashSet<>());
                    res = Math.min(res, set1.size() + set2.size() + set3.size() - 6);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
