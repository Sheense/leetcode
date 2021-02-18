package com.company.array;

import java.util.*;

public class 从相邻元素对还原数组 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<adjacentPairs.length;i++) {
            map.computeIfAbsent(adjacentPairs[i][0], x-> new ArrayList<>()).add(i);
            map.computeIfAbsent(adjacentPairs[i][1], x-> new ArrayList<>()).add(i);
        }
        int start = 0;
        for(int key:map.keySet()) {
            if(map.get(key).size()==1) {
                start = key;
                break;
            }
        }
        int index = 0;
        int[] res = new int[adjacentPairs.length+1];
        int last = -1;
        while(index<res.length) {
            res[index++] = start;
            List<Integer> list = map.get(start);
            if(list.size()==1) {
                int i = list.get(0);
                start = adjacentPairs[i][0] == start?adjacentPairs[i][1]:adjacentPairs[i][0];
                last = i;
            }else {
                int i = list.get(0)==last?list.get(1):list.get(0);
                start = adjacentPairs[i][0] == start?adjacentPairs[i][1]:adjacentPairs[i][0];
                last = i;
            }
        }
        return res;
    }
}
