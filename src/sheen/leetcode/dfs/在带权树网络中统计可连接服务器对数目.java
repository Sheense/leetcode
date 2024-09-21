package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 在带权树网络中统计可连接服务器对数目
 * @Date 2024/6/4 00:41
 * @Created by sheen
 * @Description TODO
 */
public class 在带权树网络中统计可连接服务器对数目 {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        int[] res = new int[edges.length + 1];
        for(int i = 0; i < edges.length + 1; i++) {
            int pre = 0;
            for(int[] next : map.getOrDefault(i, new ArrayList<>())) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                int cnt = find(map, next[0], next[1], signalSpeed, set);
                res[i] += pre * cnt;
                pre += cnt;
            }
        }
        return res;
    }

    public int find(Map<Integer, List<int[]>> map, int point, int len, int signalSpeed, Set<Integer> set) {
        set.add(point);
        int res = 0;
        if(len % signalSpeed == 0) {
            res++;
        }

        for(int next[] : map.getOrDefault(point, new ArrayList<>())) {
            if (!set.contains(next[0])) {
                res += find(map, next[0], len + next[1], signalSpeed, set);
            }
        }

        return res;
    }

}
