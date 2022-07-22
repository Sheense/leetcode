package sheen.leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最大网络秩 {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length==0) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<roads.length;i++) {
            map.computeIfAbsent(roads[i][0], x -> new HashSet<>()).add(roads[i][1]);
            map.computeIfAbsent(roads[i][1], x -> new HashSet<>()).add(roads[i][0]);

        }
        int max = 0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(map.getOrDefault(i, new HashSet<>()).contains(j)) {
                    max = Math.max(max, map.getOrDefault(i, new HashSet<>()).size()+map.getOrDefault(j, new HashSet<>()).size()-1);
                }else {
                    max = Math.max(max, map.getOrDefault(i, new HashSet<>()).size()+map.getOrDefault(j, new HashSet<>()).size());
                }
            }
        }
        return max;
    }
}
