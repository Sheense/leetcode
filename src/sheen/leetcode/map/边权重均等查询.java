package sheen.leetcode.map;

import java.util.List;
import java.util.Map;

/**
 * @Classname 边权重均等查询
 * @Date 2024/1/26 00:50
 * @Created by sheen
 * @Description 不会，求最近公共祖先
 */
public class 边权重均等查询 {
    private int W = 26;
    /*public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {

    }*/
    public void tarjan(int node, int parent, Map<Integer, Integer>[] neighbors, List<int[]>[] queryArr, int[][] count, boolean[] visited, int[] uf, int[] lca) {
        if (parent != -1) {
            System.arraycopy(count[parent], 0, count[node], 0, W + 1);
            count[node][neighbors[node].get(parent)]++;
        }
        uf[node] = node;
        for (int child : neighbors[node].keySet()) {
            if (child == parent) {
                continue;
            }
            tarjan(child, node, neighbors, queryArr, count, visited, uf, lca);
            uf[child] = node;
        }
        for (int[] pair : queryArr[node]) {
            int node1 = pair[0], index = pair[1];
            if (node != node1 && !visited[node1]) {
                continue;
            }
            lca[index] = find(uf, node1);
        }
        visited[node] = true;
    }

    public int find(int[] uf, int i) {
        if (uf[i] == i) {
            return i;
        }
        uf[i] = find(uf, uf[i]);
        return uf[i];
    }
}
