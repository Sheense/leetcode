package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 受限条件下可到达节点的数目
 * @Date 2024/3/2 00:50
 * @Created by sheen
 * @Description TODO
 */
public class 受限条件下可到达节点的数目 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] list = new List[n];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        Set<Integer> set = new HashSet<>();
        for(int v : restricted) {
            set.add(v);
        }
        return dfs(list, 0, -1, 0, set);
    }

    public int dfs(List<Integer>[] list, int now, int pre, int res, Set<Integer> set) {
        res++;
        for(int v : list[now]) {
            if(v != pre && !set.contains(v)) {
                res = dfs(list, v, now, res, set);
            }
        }

        return res;
    }
}
