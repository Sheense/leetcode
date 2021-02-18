package com.company.bitOperation;

public class 由斜杠划分区域 {
    public static void main(String[] args) {
        由斜杠划分区域 s = new 由斜杠划分区域();
        System.out.println(s.regionsBySlashes(new String[]{" /","/ "}));
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(4*n*n);
        for(int i=0;i<grid.length;i++) {
            char[] row = grid[i].toCharArray();
            for(int j=0;j<row.length;j++) {
                if (row[j]==' '||row[j]=='/') {
                    int r1 = unionFind.union(4*(i*n+j), 4*(i*n+j)+1);
                    int r2 = unionFind.union(4*(i*n+j)+2, 4*(i*n+j)+3);
                    if(row[j]==' ') {
                        unionFind.union(r1, r2);
                    }
                }else {
                    unionFind.union(4*(i*n+j), 4*(i*n+j)+3);
                    unionFind.union(4*(i*n+j)+1, 4*(i*n+j)+2);
                }

                if(j+1<n) {
                    unionFind.union(4*(i*n+j)+3, 4*(i*n+j+1)+1);
                }
                if(i+1<n) {
                    unionFind.union(4*(i*n+j)+2, 4*((i+1)*n+j));
                }
            }
        }
        return unionFind.getCount();
    }
    public class UnionFind{
        private int count;
        private int[] parent;
        public UnionFind(int size) {
            parent = new int[size];
            for(int i=0;i<size;i++) parent[i] = i;
            count = size;
        }

        public int findRoot(int i) {
            while (i!=parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public int union(int i, int j) {
            int r1 = findRoot(i);
            int r2 = findRoot(j);
            if(r1==r2) return r1;
            count--;
            parent[r1] = r2;
            return r2;
        }

        public int getCount() {
            return count;
        }
    }
}
