package com.company.DisjointSetUnion;

public class 情侣牵手 {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        UnionFind unionFind = new UnionFind(len/2);
        for(int i=0;i<len;i+=2) {
            unionFind.unionFind(row[i]/2, row[i+1]/2);
        }
        return len/2 - unionFind.getCount();
    }

    public class UnionFind{
        int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            parent= new int[n];
            for(int i=0;i<parent.length;i++) parent[i] = i;
            count = n;
        }

        public int findRoot(int i) {
            while(i!=parent[i]) i = parent[i];
            return i;
        }

        public void unionFind(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1==r2) return;
            parent[r1] = r2;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
