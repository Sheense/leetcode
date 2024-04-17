package sheen.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 统计可能的树根数目
 * @Date 2024/2/29 01:10
 * @Created by sheen
 * @Description TODO
 */
public class 统计可能的树根数目 {
    public static void main(String[] args) {
        统计可能的树根数目 s = new 统计可能的树根数目();
        System.out.println(s.rootCount(new int[][]{{0,1},{1,2},{1,3},{4,2}},
                new int[][]{{1,3},{0,1},{1,0},{2,4}}, 3
));
    }
    private int res = 0;
    private int cnt = 0;
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        Set<Long> set = new HashSet<>();
        for(int[] guess : guesses) {
            set.add(hash(guess[0], guess[1]));
        }

        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new HashSet<>()).add(edge[0]);
        }

        dfs(0, -1, set);
        process(cnt, 0, -1, set, k);

        return res;
    }

    public void process(int cnt, int x, int pre, Set<Long> set, int k) {
        if(cnt >= k) {
            res++;
        }

        for(int v : map.get(x)) {
            if(pre != v) {
                process(cnt + (set.contains(hash(x, v) )? -1 : 0) + (set.contains(hash(v, x) )? 1 : 0), v, x, set, k);
            }
        }
    }

    public void dfs(int x, int pre, Set<Long> set) {
        for(int v : map.get(x)) {
            if(v != pre) {
                if(set.contains(hash(x, v))) {
                    cnt++;
                }
                dfs(v, x, set);
            }
        }
    }

    public long hash(long x, long y) {
        return (x << 20) | y;
    }
}
