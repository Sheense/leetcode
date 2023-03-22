package sheen.leetcode.tree;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 树中距离之和
 * @Date 2023/3/22 11:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 树中距离之和 {
    public static void main(String[] args) {
        树中距离之和 s = new 树中距离之和();
        ArrayUtils.print(s.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}}));
    }

    private int[] dp;
    private int[] su;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        dp = new int[n];
        su = new int[n];
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for(int i = 0; i < edges.length; i++) {
            lists[edges[i][0]].add(edges[i][1]);
            lists[edges[i][1]].add(edges[i][0]);
        }

        dfs(lists, 0, new HashSet<>());
        dfs2(lists, 0, new HashSet<>());
        return dp;
    }

    public void dfs2(List<Integer>[] lists, int v, Set<Integer> set) {
        List<Integer> children = lists[v];
        set.add(v);
        for(int child : children) {
            if(!set.contains(child)) {
                //将child选为root，将v为root减去child选为root的贡献
                int item = dp[v] - (dp[child] + su[child]);
                //item为除了child子树上的节点，其余节点到v的贡献，在child的贡献上加上item和v的内部节点数量为v的节点数减去child的节点数
                dp[child] += item + (su[v] - su[child]);
                su[child] = su[v];
                dfs2(lists, child, set);
            }
        }
    }

    public int dfs(List[] lists, int v, Set<Integer> set) {
        List<Integer> list = lists[v];
        su[v] = 1;
        set.add(v);
        int res = 0;
        for(int item : list) {
            if(!set.contains(item)) {
                res += dfs(lists, item, set) + su[item];
                su[v] += su[item];
            }
        }
        dp[v] = res;
        return dp[v];
    }
}
