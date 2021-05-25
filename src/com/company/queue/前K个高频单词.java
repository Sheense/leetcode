package com.company.queue;

import java.util.*;

public class 前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if(map.get(o1) != map.get(o2)) {
                return map.get(o2) - map.get(o1);
            }else {
                return o1.compareTo(o2);
            }
        });
        for(String str:map.keySet()) {
            queue.add(str);
        }
        List<String> res = new ArrayList<>();
        while (k--!=0) {
            res.add(queue.poll());
        }
        return res;
    }
}
