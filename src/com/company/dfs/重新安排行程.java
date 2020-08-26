package com.company.dfs;

import java.util.*;

public class 重新安排行程 {

    public static void main(String[] args) {
        重新安排行程 s = new 重新安排行程();
        System.out.println(s.findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"),Arrays.asList("JFK", "MUC"),Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"))));
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<tickets.size();i++) {
            map.computeIfAbsent(tickets.get(i).get(0), x -> new ArrayList<>()).add(tickets.get(i).get(1));
        }
        for(List<String> list: map.values()) {
            Collections.sort(list);
        }
        Stack<String> stack = new Stack<>();
        recall(map, stack, "JFK");
        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public void recall(Map<String,List<String>> map, Stack<String> stack, String now) {
        List<String> next = map.get(now);
        if (next==null||next.size()==0) {
            stack.push(now);
            return;
        }
        while(next.size()!=0) {
            String nextPoint = next.get(0);
            next.remove(0);
            recall(map, stack, nextPoint);
        }
        stack.push(now);
    }
}
