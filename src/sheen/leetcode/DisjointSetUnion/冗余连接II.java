package sheen.leetcode.DisjointSetUnion;

import sheen.leetcode.util.ArrayUtils;

public class 冗余连接II {
    public static void main(String[] args) {
        冗余连接II s = new 冗余连接II();
        ArrayUtils.print(s.findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}}));
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        for (int i=1;i<parents.length;i++) {
            parents[i] = i;
        }
        int [] du = new int[edges.length+1];
        int node = 0;
        for(int i=0;i<edges.length;i++) {
            du[edges[i][1]]++;
            if(du[edges[i][1]]==2) {
                node = edges[i][1];
            }
        }
        int[] res = null;
        if (node == 0) {
            for(int i=0;i<edges.length;i++) {
                int root1 = findParent(parents, edges[i][0]);
                int root2 = findParent(parents, edges[i][1]);
                if (root1 == root2) {
                    res = edges[i];
                    break;
                }
                parents[root1] = root2;
            }
        } else {
            int[][] line = new int[2][2];
            int index = 0;
            for(int i=0;i<edges.length;i++) {
                if(edges[i][1] == node) {
                    line[index++] = edges[i];
                    continue;
                }
                int root1 = findParent(parents, edges[i][0]);
                int root2 = findParent(parents, edges[i][1]);
                parents[root2] = root1;
            }
            if(check(line[0], parents)) {
                res = line[0];
            }else {
                res = line[1];
            }
        }
        return res;
    }

    public boolean check(int[] edge, int[] parents) {
        int root1 = findParent(parents, edge[0]);
        int root2 = findParent(parents, edge[1]);
        return root1 == root2;
    }

    public int findParent(int[] parents, int index) {
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;
    }
}
