package sheen.leetcode.array;

import java.util.*;

public class 执行交换操作后的最小汉明距离 {
    public static void main(String[] args) {
        执行交换操作后的最小汉明距离 s = new 执行交换操作后的最小汉明距离();
        System.out.println(s.minimumHammingDistance(new int[]{41,37,51,100,25,33,90,49,65,87,11,18,15,18},
                new int[]{41,92,69,75,29,13,53,21,17,81,33,19,33,32},
                new int[][]{{0,11},{5,9},{6,9},{5,7},{8,13},{4,8},{12,7},{8,2},{13,5},
        {0,7},{6,4},{8,9},{4,12},{6,1},{10,0},{10,2},{7,3},{11,10},{5,2},{11,1},{3,0},{8,5},
        {12,6},{2,1},{11,2},{4,9},{2,9},{10,6},{12,10},{4,13},{13,2},{11,9},{3,6},
        {0,4},{1,10},{5,11},{12,1},{10,4},{6,2},{10,7},{3,13},{4,5},{13,10},{4,7},
        {0,12},{9,10},{9,3},{0,5},{1,9},{5,10},{8,0},{12,11},{11,4},{7,9},{7,2},
        {13,9},{12,3},{8,6},{7,6},{8,12},{4,3},{7,13},{0,13},
        {2,0},{3,8},{8,1},{13,6},{1,4},{0,9},{2,3},{8,7},{4,2},{9,12}}));
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int[] set = new int[source.length];
        for(int i=0;i<set.length;i++) {
            set[i] = i;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(source[i], 1);
            map.put(i, m);
        }
        for(int i=0;i<allowedSwaps.length;i++) {
            union(allowedSwaps[i][0], allowedSwaps[i][1], set, map);
        }
        int res = 0;
        for(int i=0;i<target.length;i++) {
            int root = findRoot(i, set);
            Map<Integer,Integer> m = map.get(root);
            if(m.containsKey(target[i])) {
                if(m.get(target[i])!=0) {
                    m.put(target[i], m.get(target[i])-1);
                }else {
                    res++;
                }
            }else {
                res++;
            }
        }
        return res;
    }

    public void union(int i, int j, int[] set, Map<Integer, Map<Integer, Integer>> map) {
        int root1 = findRoot(i, set);
        int root2 = findRoot(j, set);
        if(root1==root2) return;
        set[root1] = root2;
        Map<Integer, Integer> r1Map = map.get(root1);
        Map<Integer, Integer> r2Map = map.get(root2);
        for(int key:r1Map.keySet()) {
            r2Map.put(key, r2Map.getOrDefault(key, 0)+r1Map.get(key));
        }
    }

    public int findRoot(int i, int[] set) {
        while(set[i]!=i) {
            i = set[i];
        }
        return i;
    }

}
