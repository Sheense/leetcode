package sheen.leetcode.DisjointSetUnion;

import java.util.ArrayList;
import java.util.List;

public class 保证图可完全遍历 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        List<int[]> type1 = new ArrayList<>();
        List<int[]> type2 = new ArrayList<>();
        List<int[]> type3 = new ArrayList<>();
        for(int i=0;i<edges.length;i++) {
            switch (edges[i][0]) {
                case 1:type1.add(edges[i]);break;
                case 2:type2.add(edges[i]);break;
                case 3:type3.add(edges[i]);break;
            }
        }
        int res = 0;
        UnionFind common = new UnionFind(n);
        for (int[] arr : type3) {
            if(!common.union(arr[1], arr[2])) {
                res++;
            }
        }
        if(common.getCount()==1) {
            return res + type1.size() + type2.size();
        }
        UnionFind Alice = common;
        UnionFind Bob = common.deepClone();
        for(int[] arr : type1) {
            if(!Alice.union(arr[1], arr[2])) {
                res++;
            }
        }
        if(Alice.getCount()>1) {
            return -1;
        }
        for(int[] arr : type2) {
            if(!Bob.union(arr[1], arr[2])) {
                res++;
            }
        }
        if(Bob.getCount()>1){
            return -1;
        }
        return res;
    }

    public class UnionFind{
        private int count = 0;
        private int[] parents;
        public UnionFind(int size) {
            count = size;
            parents = new int[size+1];
            for(int i=0;i<size;i++) parents[i] = i;
        }
        public UnionFind(int[] parents, int count) {
            this.count = count;
            this.parents = new int[parents.length];
            for(int i=0;i<parents.length;i++) this.parents[i] = parents[i];
        }

        public int findRoot(int i) {
            while(parents[i]!=i) {
                i = parents[i];
            }
            return i;
        }

        public void setRoot(int root, int i) {
            while(parents[i]!=i) {
               int next = parents[i];
               parents[i] = root;
               i = next;
            }
            parents[i] = root;
        }

        public boolean union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1 == r2) return false;
            setRoot(r2, r1);
            count--;
            return true;
        }

        public int getCount() {
            return count;
        }

        public UnionFind deepClone() {
            return new UnionFind(this.parents, this.count);
        }
    }
}
