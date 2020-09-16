package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 统计不开心的朋友 {
    public static void main(String[] args) {
        统计不开心的朋友 s = new 统计不开心的朋友();
        System.out.println(s.unhappyFriends(4,new int[][]{{1, 3, 2},{2, 3, 0},{1, 3, 0},{0, 2, 1}}, new int[][]{{1,3},{0,2}}));
    }
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=0;i<preferences.length;i++) {
            Map<Integer, Integer> m = new HashMap<>();
            map.put(i ,m);
            for(int j=0;j<preferences[i].length;j++) {
                m.put(preferences[i][j], preferences[i].length-j-1);
            }
        }
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<pairs.length-1;i++) {
            for(int j= i+1;j<pairs.length;j++) {
                int[] a = pairs[i];
                int[] b = pairs[j];
                if(!res.contains(a[0])) {
                    if(map.get(a[0]).get(a[1])<map.get(a[0]).get(b[0])&&map.get(b[0]).get(b[1])<map.get(b[0]).get(a[0])||map.get(a[0]).get(a[1])<map.get(a[0]).get(b[1])&&map.get(b[1]).get(b[0])<map.get(b[1]).get(a[0])) {
                        res.add(a[0]);
                    }
                }
                if(!res.contains(a[1])) {
                    if(map.get(a[1]).get(a[0])<map.get(a[1]).get(b[0])&&map.get(b[0]).get(b[1])<map.get(b[0]).get(a[1])||map.get(a[1]).get(a[0])<map.get(a[1]).get(b[1])&&map.get(b[1]).get(b[0])<map.get(b[1]).get(a[1])) {
                        res.add(a[1]);
                    }
                }
                if(!res.contains(b[0])) {
                    if(map.get(b[0]).get(b[1])<map.get(b[0]).get(a[0])&&map.get(a[0]).get(a[1])<map.get(a[0]).get(b[0])||map.get(b[0]).get(b[1])<map.get(b[0]).get(a[1])&&map.get(a[1]).get(a[0])<map.get(a[1]).get(b[0])) {
                        res.add(b[0]);
                    }
                }
                if(!res.contains(b[1])) {
                    if(map.get(b[1]).get(b[0])<map.get(b[1]).get(a[0])&&map.get(a[0]).get(a[1])<map.get(a[0]).get(b[1])||map.get(b[1]).get(b[0])<map.get(b[1]).get(a[1])&&map.get(a[1]).get(a[0])<map.get(a[1]).get(b[1])) {
                        res.add(b[1]);
                    }
                }
            }
        }
        return res.size();
    }
}
