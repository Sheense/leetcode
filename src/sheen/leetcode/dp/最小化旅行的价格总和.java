package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 最小化旅行的价格总和
 * @Date 2023/12/6 00:28
 * @Created by sheen
 * @Description TODO
 */
public class 最小化旅行的价格总和 {
    public static void main(String[] args) {
        最小化旅行的价格总和 s = new 最小化旅行的价格总和();
        System.out.println(s.minimumTotalPrice(4, new int[][]{{0,1},{1,2},{1,3}}, new int[]{2,2,10,6},
                new int[][]{{0,3},{2,1},{2,3}}
));
    }
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        int[] count = new int[n];
        for(int[] trip : trips) {
            dfs(trip[0], -1, trip[1], count, map);
        }

        int[][] dp = new int[n][2];
        dp(0, -1, count, map, price, dp);
        ArrayUtils.print2(dp);
        return Math.min(dp[0][0], dp[0][1]);
    }

    public void dp(int root, int pre, int[] count, Map<Integer, List<Integer>> map, int[] price, int[][] dp) {
        dp[root][0] = count[root] * price[root];
        dp[root][1] = count[root] * (price[root] / 2);
        for(int next : map.getOrDefault(root, new ArrayList<>())) {
            if(pre != next) {
                dp(next, root, count, map, price, dp);
                dp[root][0] += Math.min(dp[next][0], dp[next][1]);
                dp[root][1] += dp[next][0];
            }
        }
    }

    public boolean dfs(int start, int pre, int end, int[] count, Map<Integer, List<Integer>> map) {
        count[start]++;

        if(start == end) {
            return true;
        }
        for(int next : map.getOrDefault(start, new ArrayList<>())) {
            if(pre != next) {
                boolean flag = dfs(next, start, end, count, map);
                if(flag) {
                    return true;
                }
            }
        }

        count[start]--;
        return false;
    }
}
