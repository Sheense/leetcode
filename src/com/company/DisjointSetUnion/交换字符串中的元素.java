package com.company.DisjointSetUnion;

import java.util.*;

public class 交换字符串中的元素 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] set = new int[s.length()];
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<set.length;i++) {
            set[i] = i;
            map.computeIfAbsent(i, x -> {
                int[] arr = new int[26];
                arr[s.charAt(x)-'a']++;
                return arr;
            });
        }
        for(int i=0;i<pairs.size();i++) {
            List<Integer> list = pairs.get(i);
            union(list.get(0),list.get(1), set, map);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            int root = findRoot(set, i);
            char c = findFirst(map.get(root));
            res.append(c);
        }
        return res.toString();
    }

    public char findFirst(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0) {
                arr[i]--;
                return (char)('a'+i);
            }
        }
        return ' ';
    }

    public void union(int i, int j, int[] set, Map<Integer, int[]> map) {
        int r1 = findRoot(set, i);
        int r2 = findRoot(set, j);
        if(r1==r2) return ;
        reRoot(set, r1, j);
        int[] q1 = map.get(r1);
        int[] q2 = map.get(r2);
        for(int z=0;z<q2.length;z++) q1[z] += q2[z];
        set[r2] = r1;
    }

    public int findRoot(int[] set, int i) {
        while(i!=set[i]) {
            i = set[i];
        }
        return i;
    }

    public void reRoot(int[] set, int root, int i) {
        while(i!=set[i]) {
            int next = set[i];
            set[i] = root;
            i = next;
        }
        set[i] = root;
    }


}
