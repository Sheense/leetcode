package sheen.leetcode.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 修改图中的边权
 * @Date 2023/6/4 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 修改图中的边权 {
    public static void main(String[] args) {
        修改图中的边权 s = new 修改图中的边权();


    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]> g[] = new List[n];
        for(int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            g[edges[i][0]].add(new int[]{edges[i][1], i});
            g[edges[i][1]].add(new int[]{edges[i][0], i});
        }

        int[][] search = new int[n][2];
        for(int i = 0; i < search.length; i++) {
            if(i != source) {
                search[i][0] = search[i][1] = Integer.MAX_VALUE;
            }
        }

        dijkstra(edges, g, search, 0, destination, 0);
        int d = target - search[destination][0];
        if(d < 0) {
            return new int[][]{};
        }

        dijkstra(edges, g, search, 1, destination, d);
        if(search[destination][1] < target) {
            return new int[][]{};
        }

        for(int[] e : edges) {
            if(e[2] == -1) {
                e[2] = 1;
            }
        }

        return edges;
    }

    public void dijkstra(int[][] edges, List<int[]> g[], int[][] search, int k, int destination, int d) {
        boolean[] vis = new boolean[g.length];
        while (true) {
            int x = -1;
            for(int i = 0; i < vis.length; i++) {
                if(!vis[i] && (x < 0 || search[x][k] > search[i][k])) {
                    x = i;
                }
            }
            if(x == destination) {
                return;
            }
            vis[x] = true;
            for(int[] next : g[x]) {
                int i = next[1];
                int y = next[0];
                int wt = edges[i][2];
                if(wt == -1) {
                    wt = 1;
                }
                if(k == 1 && edges[i][2] == -1) {
                    int w = d + search[y][0] - search[x][1];
                    if(w > wt) {
                        wt = w;
                        edges[i][2] = w;
                    }
                }

                search[y][k] = Math.min(search[y][k], search[x][k] + wt);
            }
        }
    }
}
