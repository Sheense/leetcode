package com.company.DisjointSetUnion;

import java.util.HashMap;
import java.util.Map;

public class 相似字符串组 {
    public static void main(String[] args) {
        相似字符串组 s = new 相似字符串组();
        System.out.println(s.numSimilarGroups(new String[]{"tars","rats","arts","star"}));
    }
    public int numSimilarGroups(String[] strs) {
        UnionFind unionFind = new UnionFind(strs.length);
        for(int i=0;i<strs.length-1;i++) {
            for(int j=i+1;j<strs.length;j++) {
                if(check(strs[i],strs[j])) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getResult();
    }

    public class UnionFind{

        private int[] parents ;
        private int count = 0;
        public UnionFind(int size) {
            parents = new int[size];
            for(int i=0;i<parents.length;i++) parents[i] = i;
            count = size;
        }

        public int find(int i) {
            while(i!=parents[i]) i = parents[i];
            return i;
        }

        public void union(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            if(r1==r2) return;
            count --;
            parents[r1] = r2;
        }

        public int getResult() {
            return count;
        }

    }

    public boolean check(String str1, String str2) {
        int num = 0;
        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i)!=str2.charAt(i)) {
                num++;
                if(num>2) {
                    return false;
                }
            }
        }
        return true;
    }
}
