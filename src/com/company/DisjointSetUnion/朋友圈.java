package com.company.DisjointSetUnion;

public class 朋友圈 {
    public int findCircleNum(int[][] M) {
        int [] set = new int[M.length];
        for(int i=0;i<set.length;i++) {
            set[i] = i;
        }
        for(int i=0;i<M.length;i++) {
            for(int j=i+1;j<M[i].length;j++) {
                if(M[i][j]==1) {
                    int root1 = findRoot(i, set);
                    int root2 = findRoot(j, set);
                    set[root2] = root1;
                }
            }
        }
        int res = 0;
        for(int i=0;i<set.length;i++) {
            if(set[i]==i) res++;
        }
        return res;
    }
    public int findRoot(int i, int[] set) {
        while(set[i]!=i) {
            i = set[i];
        }
        return i;
    }


}
