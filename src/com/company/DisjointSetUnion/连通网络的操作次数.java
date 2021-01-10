package com.company.DisjointSetUnion;

public class 连通网络的操作次数 {
    public static void main(String[] args) {
        连通网络的操作次数 s = new 连通网络的操作次数();
        System.out.println(s.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}}));
    }
    public int makeConnected(int n, int[][] connections) {
        int[] set = new int[n];
        int[] nums = new int[n];
        for(int i=0;i<n;i++) set[i] = i;
        for(int i=0;i<connections.length;i++) {
            int r1 = findRoot(set, connections[i][0]);
            int r2 = findRoot(set, connections[i][1]);
            if(r1==r2) {
                nums[r1]++;
                continue;
            }
            reRoot(set, r1, r2);
            nums[r1] += nums[r2];
        }
        int has = 0;
        int setCount = 0;
        for(int i=0;i<n;i++){
            if(set[i]==i) {
                setCount++;
                has += nums[i];
            }
        }
        if(has>=setCount-1) {
            return setCount-1;
        }
        return -1;
    }

    public int findRoot(int[] set, int i) {
        while(i!=set[i]) {
            i = set[i];
        }
        return i;
    }

    public void reRoot(int[]set, int root, int i) {
        while(i!=set[i]) {
            int next = set[i];
            set[i] = root;
            i = next;
        }
        set[i] = root;
    }
}
