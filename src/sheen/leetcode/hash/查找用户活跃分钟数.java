package sheen.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 查找用户活跃分钟数 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<logs.length;i++) {
            map.computeIfAbsent(logs[i][0], x -> new HashSet<>()).add(logs[i][1]);
        }
        map.values().forEach(x -> {
            res[x.size()-1]++;
        });
        return res;
    }
}
