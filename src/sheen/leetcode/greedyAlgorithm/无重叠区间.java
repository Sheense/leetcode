package sheen.leetcode.greedyAlgorithm;

import java.util.*;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<intervals.length;i++) {
            map.computeIfAbsent(intervals[i][0], x -> new ArrayList<>()).add(intervals[i][1]);
        }
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int key:map.keySet()) {
            List<Integer> list = map.get(key);
            int min = list.get(0);
            for(int j=0;j<list.size();j++) {
                min = Math.min(min, list.get(j));
            }
            res+=(list.size()-1);
            m.put(key, min);
        }
        if(m.size()==0) return 0;
        List<Integer> list = new ArrayList<>(m.keySet());
        Collections.sort(list);
        int end = m.get(list.get(0));
        for(int i=1;i<list.size();i++) {
            if(end<=list.get(i)) {
                end = m.get(list.get(i));
            }else {
                if(end>m.get(list.get(i))) {
                    end = m.get(list.get(i));
                }
                res++;
            }
        }
        return res;
    }
}
