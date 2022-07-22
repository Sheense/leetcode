package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 到达目的地的方案数
 * @Date 2021/8/21 11:25 下午
 * @Created by sheen
 * @Description TODO
 */
public class 到达目的地的方案数 {
    public static void main(String[] args) {
        到达目的地的方案数 s = new 到达目的地的方案数();
        System.out.println(s.countPaths(7, new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = (int)Math.pow(10, 9) + 7;
        long MAX_TIME = Long.MAX_VALUE;
        long[][] dp = new long[n][2];
        List<List<long[]>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            dp[i][0] = MAX_TIME;
            list.add(new ArrayList<>());
        }
        dp[0][0] = 0;
        dp[0][1] = 1;

        for(int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            int time = roads[i][2];
            list.get(x).add(new long[]{time, y});
            list.get(y).add(new long[]{time, x});
        }

        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1] >= 0 ? 1 : -1);
        queue.add(new long[]{0L, 0L});
        while (!queue.isEmpty()) {
            long[] p = queue.poll();
            long time = p[0];
            int point = (int)p[1];
            if(dp[point][0] < time) {
                continue;
            }

            for(long[] next : list.get(point)) {
                int nextPoint = (int)next[1];
                long nextTime = next[0];
                if(nextTime + dp[point][0] < dp[nextPoint][0]) {
                    dp[nextPoint][0] = nextTime + dp[point][0];
                    dp[nextPoint][1] = dp[point][1];
                    queue.add(new long[]{nextTime + dp[point][0], nextPoint});
                }else if(nextTime + dp[point][0] == dp[nextPoint][0]) {
                    dp[nextPoint][1] += dp[point][1];
                    dp[nextPoint][1] %= MOD;
                }
            }
        }
        return (int)(dp[n-1][1]%MOD);
    }
}
