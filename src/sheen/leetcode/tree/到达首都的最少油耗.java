package sheen.leetcode.tree;

import java.util.*;

/**
 * @Classname 到达首都的最少油耗
 * @Date 2023/12/5 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 到达首都的最少油耗 {
    private int res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < roads.length; i++) {
            map.computeIfAbsent(roads[i][0], x -> new ArrayList<>()).add(roads[i][1]);
            map.computeIfAbsent(roads[i][1], x -> new ArrayList<>()).add(roads[i][0]);
        }


        dfs(0, -1, map, seats);
        return res;
    }

    public int dfs(int cur, int fa, Map<Integer, List<Integer>> map, int seats) {
        int count = 1;
        for(int next : map.getOrDefault(cur, new ArrayList<>())) {
            if(next != fa) {
                int nextCount = dfs(next, cur, map, seats);
                count += nextCount;
                res += (nextCount + seats - 1) / seats;
            }
        }

        return count;
    }
}
