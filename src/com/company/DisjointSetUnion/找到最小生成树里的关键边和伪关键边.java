package com.company.DisjointSetUnion;

import java.lang.reflect.Array;
import java.util.*;

public class 找到最小生成树里的关键边和伪关键边 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] copy = new int[edges.length][4];
        for(int i=0;i<edges.length;i++) {
            for(int j=0;j<edges[i].length;j++) {
                copy[i][j] = edges[i][j];
            }
            copy[i][3] = i;
        }
        sort(copy, 0 ,copy.length-1);
        UnionFind unionFind = new UnionFind(n);
        int min = 0;
        for(int i=0;i<copy.length;i++) {
            if(unionFind.union(copy[i][0], copy[i][1])) {
                min += copy[i][2];
            }
        }
        List<Integer> importEdges = new ArrayList<>();
        List<Integer> nonImportEdges = new ArrayList<>();
        for(int i=0;i<copy.length;i++) {
            UnionFind u = new UnionFind(n);
            int m = 0;
            for(int j=0;j<copy.length;j++) {
                if(i!=j&&u.union(copy[j][0], copy[j][1])) {
                    m += copy[j][2];
                }
            }
            if(u.mapSize>1 || (m>min&&u.mapSize==1)) {
                importEdges.add(copy[i][3]);
            }else {
                u = new UnionFind(n);
                m = copy[i][2];
                u.union(copy[i][0],copy[i][1]);
                for(int j=0;j<copy.length;j++) {
                    if(i!=j&&u.union(copy[j][0], copy[j][1])) {
                        m += copy[j][2];
                    }
                }
                if(m==min) {
                    nonImportEdges.add(copy[i][3]);
                }
            }
        }
        return Arrays.asList(importEdges, nonImportEdges);
    }

    public void sort(int[][] edges, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int[] now = edges[left];
        while(left<right) {
            while(left<right&&edges[right][2]>=now[2]) right--;
            edges[left] = edges[right];
            while(left<right&&edges[left][2]<=now[2]) left++;
            edges[right] = edges[left];
        }
        edges[left] = now;
        sort(edges, start, left-1);
        sort(edges, left+1, end);
    }

    public class UnionFind{
        int[] parent;
        int mapSize = 0;
        public UnionFind(int n) {
            parent = new int[n];
            for(int i=0;i<parent.length;i++) parent[i] = i;
            mapSize = n;
        }

        public int findRoot(int i) {
            while(i!=parent[i]) i= parent[i];
            return i;
        }

        public boolean union(int i, int j) {
            if(mapSize==1) return false;
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1==r2) return false;
            parent[r1] = r2;
            mapSize--;
            return true;
        }
    }
}
