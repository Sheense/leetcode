package com.company.DisjointSetUnion;

public class 冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length+1];
        for(int i=1;i<parent.length;i++) {
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++) {
            if(parent[edges[i][1]] == edges[i][1] || parent[edges[i][1]] == edges[i][0]) {
                parent[edges[i][1]] = edges[i][0];
            }else {

            }
        }
    }

    public int findParent(int[] parent, int index) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    public int union(int[] parent, int index1, int index2) {
        int time1 = 0;
        while(parent[index1]!=index1) {
            index1 = parent[index1];
            time1++;
        }
        int time2 = 0;
        while(parent[index2]!=index2) {
            index2 = parent[index2];
            time2++;
        }
        if()
    }
}
