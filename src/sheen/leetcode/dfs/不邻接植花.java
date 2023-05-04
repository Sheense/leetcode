package sheen.leetcode.dfs;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 不邻接植花
 * @Date 2023/4/15 1:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 不邻接植花 {
    public static void main(String[] args) {
        不邻接植花 s = new 不邻接植花();
        ArrayUtils.print(s.gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}}));
        ArrayUtils.print(s.gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}}));
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < paths.length; i++) {
            map.computeIfAbsent(paths[i][0] - 1, x -> new HashSet<>()).add(paths[i][1] - 1);
            map.computeIfAbsent(paths[i][1] - 1, x -> new HashSet<>()).add(paths[i][0] - 1);
        }
        int[] res = new int[n];
        for(int i = 0; i < res.length; i++) {
            if(res[i] == 0) {
                recall(res, map, i);
            }
        }
        return res;
    }

    public void recall(int[] res, Map<Integer, Set<Integer>> map, int now) {
        Set<Integer> set = map.getOrDefault(now, new HashSet<>());
        int a = 0;
        List<Integer> next = new ArrayList<>();
        for(int v : set) {
            if(res[v] == 0) {
                next.add(v);
            }else {
                a |= 1 << (res[v] - 1);
            }
        }

        for(int i = 0; i < 4; i++) {
            if(((1 << i) & a) == 0) {
                res[now] = i + 1;
            }
        }

        for(int v : next) {
            if(res[v] == 0) {
                recall(res, map, v);
            }
        }
    }
}
