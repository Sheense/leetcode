package com.company.DisjointSetUnion;

public class 冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length+1];
        for(int i=1;i<parent.length;i++) {
            parent[i] = i;
        }
        int [] res = null;
        for(int i=0;i<edges.length;i++) {
            int root1 = findParent(parent, edges[i][1]);
            int root2 = findParent(parent, edges[i][0]);
            if (root1 == root2) {
                res = edges[i];
            }
            parent[root1] = root2;
        }
        return res;
    }

    public int findParent(int[] parent, int index) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
