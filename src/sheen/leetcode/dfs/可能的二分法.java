package sheen.leetcode.dfs;

import java.util.*;

/**
 * @Classname 可能的二分法
 * @Date 2022/10/16 11:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可能的二分法 {
    public static void main(String[] args) {
        可能的二分法 s = new 可能的二分法();
        System.out.println(s.possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < dislikes.length; i++) {
            map.computeIfAbsent(dislikes[i][0], x -> new LinkedList<>()).add(dislikes[i][1]);
            map.computeIfAbsent(dislikes[i][1], x -> new LinkedList<>()).add(dislikes[i][0]);
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            if(!set1.contains(i) && !set2.contains(i)) {
                boolean res = dfs(i, set1, set2, true, map);
                if(!res) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int v, Set<Integer> set1, Set<Integer> set2, boolean first, Map<Integer, List<Integer>> map) {
        List<Integer> list = map.get(v);
        if(list == null) {
            return true;
        }
        if(first) {
            set1.add(v);
            for(int next : list) {
                if(set1.contains(next)) {
                    return false;
                }else {
                    if(set2.contains(next)) {
                        continue;
                    }
                    boolean res = dfs(next, set1, set2, false, map);
                    if(!res) {
                        return false;
                    }
                }
            }
        }else {
            set2.add(v);
            for(int next : list) {
                if(set2.contains(next)) {
                    return false;
                }else {
                    if(set1.contains(next)) {
                        continue;
                    }
                    boolean res = dfs(next, set1, set2, true, map);
                    if(!res) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
