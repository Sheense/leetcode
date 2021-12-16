package com.company.design;

import java.util.*;

/**
 * @Classname 在线选举
 * @Date 2021/12/11 5:03 下午
 * @Created by sheen
 * @Description TODO
 */
public class 在线选举 {
    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        topVotedCandidate.q(3);
    }
    static class TopVotedCandidate {
        Map<Integer, Integer> map1 = new HashMap<>();
        private TreeMap<Integer, Integer> map2 = new TreeMap<>();

        private TreeMap<Integer, List<Integer>> map3 = new TreeMap<>();
        public TopVotedCandidate(int[] persons, int[] times) {
            for(int i = 0; i < persons.length; i++) {
                map1.put(persons[i], map1.getOrDefault(persons[i], 0) + 1);
                int v = map1.get(persons[i]);
                map3.computeIfAbsent(v, x -> new ArrayList<>()).add(persons[i]);
                List<Integer> list = map3.lastEntry().getValue();
                map2.put(times[i], list.get(list.size() - 1));
            }
        }

        public int q(int t) {
            int key = map2.floorEntry(t).getKey();
            return map2.floorEntry(t).getValue();
        }
    }
}
