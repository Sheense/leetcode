package sheen.leetcode.map;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 统计子树中城市之间最大距离
 * @Date 2023/3/12 1:19 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计子树中城市之间最大距离 {
    public static void main(String[] args) {
        统计子树中城市之间最大距离 s = new 统计子树中城市之间最大距离();
       ArrayUtils.print(s.countSubgraphsForEachDiameter(4, new int[][]{{1,2},{2,3},{2,4}}));
    }
    private int diameter;
    private int mask;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            adj[edges[i][0] - 1].add(edges[i][1] - 1);
            adj[edges[i][1] - 1].add(edges[i][0] - 1);
        }

        int[] res = new int[n - 1];
        for(int i = 1; i < (1 << n); i++) {
            int root = 32 - Integer.numberOfLeadingZeros(i) - 1;
            diameter = 0;
            mask = i;
            dfs(root, adj);
            if(mask == 0 && diameter > 0) {
                res[diameter - 1]++;
            }

        }

        return res;

    }

    public int dfs(int root, List<Integer>[] adj) {
        int first = 0;
        int second = 0;
        mask &= ~(1 << root);
        for(int next : adj[root]) {
            boolean check = (mask & (1 << next)) > 0;
            if(check) {
                int distance = 1 + dfs(next, adj);
                if(distance > first) {
                    second = first;
                    first = distance;
                }else if(distance > second) {
                    second = distance;
                }
            }
        }
        diameter = Math.max(diameter, first + second);
        return first;
    }
}
