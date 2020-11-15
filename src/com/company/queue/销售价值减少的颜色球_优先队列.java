package com.company.queue;

import java.util.*;

public class 销售价值减少的颜色球_优先队列 {
    public int maxProfit(int[] inventory, int orders) {
        Queue<Integer> pq = new PriorityQueue<>(11, (i1, i2) -> i2 - i1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inventory.length;i++) {
            if(map.containsKey(inventory[i])) {
                map.put(inventory[i], map.get(inventory[i])+1);
            } else {
                pq.add(inventory[i]);
                map.put(inventory[i], 1);
            }
        }
        int res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        while(orders!=0) {
            int value = pq.poll();
            int tiem = map.get(value);
            int next=
            while()
        }
        return res;
    }
}
