package com.company.DisjointSetUnion;

import java.util.PriorityQueue;

public class 最小体力消耗路径 {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]);
        UnionFind unionFind = new UnionFind(heights.length * heights[0].length);
        for(int i=0;i<heights.length;i++) {
            for(int j=0;j<heights[i].length;j++) {
                if(i+1<heights.length) {
                    int[] arr = {Math.abs(heights[i][j]-heights[i+1][j]), i*heights[0].length+j, (i+1)*heights[0].length+j};
                    queue.add(arr);
                }
                if(j+1<heights[0].length) {
                    int[] arr = {Math.abs(heights[i][j]-heights[i][j+1]), i*heights[0].length+j, i*heights[0].length+j+1};
                    queue.add(arr);
                }
            }
        }
        while (!queue.isEmpty()) {
            int arr[] = queue.poll();
            unionFind.union(arr[1], arr[2]);
            if(unionFind.isResult()) {
                return arr[0];
            }
        }
        return 0;
    }

    public class UnionFind{
        int[] parents;
        int start = 0;
        int end = 0;
       public UnionFind(int size) {
           parents = new int[size];
           end = size-1;
           for(int i=0;i<parents.length;i++) parents[i] = i;
       }

       public int findRoot(int i) {
           while (i!=parents[i]) i = parents[i];
           return i;
       }

       public void union(int i, int j) {
           int r1 = findRoot(i);
           int r2 = findRoot(j);
           if(r1 == r2) return;
           parents[r1] = r2;
       }

       public boolean isResult() {
           return findRoot(end) == findRoot(start);
       }


    }
}
