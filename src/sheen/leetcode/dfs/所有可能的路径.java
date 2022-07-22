package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 所有可能的路径
 * @Date 2021/8/25 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 所有可能的路径 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                map.computeIfAbsent(i, x -> new ArrayList<>()).add(graph[i][j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(res, map, 0, graph.length - 1, list);
        return res;
    }

    public void dfs(List<List<Integer>> res, Map<Integer, List<Integer>> map, int now, int end, List<Integer> list) {
        if(now == end) {
            res.add(list);
            return;
        }
        List<Integer> l = map.get(now);
        if(l != null) {
            for(int next : l) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(next);
                dfs(res, map, next, end, copy);
            }
        }
    }
}
