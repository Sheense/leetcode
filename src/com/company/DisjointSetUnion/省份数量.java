package com.company.DisjointSetUnion;

class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int[] set = new int[isConnected.length];
        for(int i=0;i<set.length;i++) set[i] = i;
        for(int i=0;i<isConnected.length;i++) {
            for(int j=0;j<isConnected[i].length;j++) {
                if(isConnected[i][j]==1) {
                    int root1 = findRoot(i, set);
                    int root2 = findRoot(j, set);
                    set[root1] = root2;
                }
            }
        }
        int res = 0;
        for(int i=0;i<set.length;i++) {
            if(set[i]==i) res++;
        }
        return res;
    }

    public int findRoot(int i, int set[]) {
        while(set[i]!=i) {
            i = set[i];
        }
        return i;
    }
}
