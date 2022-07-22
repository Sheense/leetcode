package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 到达目的地的第二短时间
 * @Date 2022/1/24 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 到达目的地的第二短时间 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(edges[i][0]);
        }

        int[][] path = new int[n+1][2];
        for(int i = 0; i < path.length; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }

        path[1][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] point = queue.poll();
            int cur = point[0];
            int len = point[1];
            for(int next : map.getOrDefault(cur, new ArrayList<>())) {
                if(len + 1 < path[next][0]) {
                    path[next][0] = len+1;
                    queue.offer(new int[]{next, len + 1});
                }else if(len + 1 > path[next][0] && len + 1 < path[next][1]) {
                    path[next][1] = len + 1;
                    queue.offer(new int[]{next, len + 1});
                }
            }
        }

        int v = path[n][1];
        int res = 0;
        for(int i = 0; i < v; i++) {
            if((res / change) % 2 != 0) {
                res += change - (res % change);
            }
            res += time;
        }
        return res;
    }

}
