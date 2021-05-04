package com.company.dp;

import java.util.*;

public class 青蛙过河 {
    public static void main(String[] args) {
        青蛙过河 s = new 青蛙过河();
        System.out.println(s.canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=stones.length-2;i>=0;i--) {
            Set<Integer> set = map.computeIfAbsent(i, x -> new HashSet<>());
            for(int j=i+1;j<stones.length;j++) {
                int interval = stones[j] - stones[i];
                if(j == stones.length - 1) {
                    set.add(interval);
                    continue;
                }
                Set<Integer> next = map.get(j);
                if(next.contains(interval) || next.contains(interval-1) || next.contains(interval + 1)) {
                    set.add(interval);
                }
            }
        }
        return map.get(0).contains(1);
    }

}
