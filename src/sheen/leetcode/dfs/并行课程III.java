package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 并行课程III
 * @Date 2023/7/28 00:07
 * @Created by sheen
 * @Description TODO
 */
public class 并行课程III {
    public static void main(String[] args) {
        并行课程III s = new 并行课程III();
        System.out.println(s.minimumTime(3, new int[][]{{1,3},{2,3}}, new int[]{3,2,5}));
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] list = new List[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < relations.length; i++) {
            list[relations[i][0] - 1].add(relations[i][1] - 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dfs(list, i, map, time));
        }
        return res;
    }

    public int dfs(List<Integer>[] list, int now, Map<Integer, Integer> map, int[] ties) {
        if(!map.containsKey(now)) {
            int res = 0;
            for(int next : list[now]) {
                res = Math.max(res, dfs(list, next, map, ties));
            }
            res += ties[now];
            map.put(now, res);
        }
        return map.get(now);
    }
}
