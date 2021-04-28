package com.company.tree;

import java.util.TreeMap;

public class 数字流的秩 {
    class StreamRank {


        private TreeMap<Integer, Integer> map;
        public StreamRank() {
            map = new TreeMap<>();
        }

        public void track(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        public int getRankOfNumber(int x) {
            int res = 0;
            if(map.containsKey(x)) {
                res += map.get(x);
            }
            for(int i: map.headMap(x).keySet()) {
                res += map.get(i);
            }
            return res;
        }
    }
}
