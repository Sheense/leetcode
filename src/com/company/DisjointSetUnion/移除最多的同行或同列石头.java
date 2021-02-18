package com.company.DisjointSetUnion;

import java.util.HashMap;
import java.util.Map;

//一个联通分量只会剩下一个
public class 移除最多的同行或同列石头 {
    public int removeStones(int[][] stones) {
        int [] set = new int[stones.length];
        for(int i=0;i<set.length;i++) set[i] = i;
        Map<Integer, Integer> rowToNum = new HashMap<>();
        Map<Integer, Integer> columnToNum = new HashMap<>();
        for(int i=0;i<stones.length;i++) {
            int r1 = i;
            if(rowToNum.containsKey(stones[i][0])) {
                r1 = find(rowToNum.get(stones[i][0]), set);
            }else {
                rowToNum.put(stones[i][0], i);
            }
            int r2 = i;
            if(columnToNum.containsKey(stones[i][1])) {
                r2 = find(columnToNum.get(stones[i][1]), set);
            }else {
                columnToNum.put(stones[i][1], i);
            }
            set[r1] = r2;
            set[i] = r2;
        }
        int l = 0;
        for(int i=0;i<set.length;i++) {
            if(set[i]==i) l++;
        }
        return set.length-l;
    }
    public int find(int i, int[] set) {
        while(i!=set[i]) {
            i = set[i];
        }
        return i;
    }
}
