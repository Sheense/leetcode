package com.company.queue;

import java.util.*;

public class 钥匙和房间 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                int index = queue.poll();
                set.add(index);
                List<Integer> list = rooms.get(index);
                for(int i : list) {
                    if(!set.contains(i)) {
                        queue.offer(i);
                    }
                }
            }
        }
        if(set.size()==rooms.size()) return true;
        else return false;
    }
}
