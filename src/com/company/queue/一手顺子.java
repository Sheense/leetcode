package com.company.queue;

import java.util.*;

/**
 * @Classname 一手顺子
 * @Date 2021/12/30 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 一手顺子 {
    public static void main(String[] args) {
        一手顺子 s = new 一手顺子();
        System.out.println(s.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0 ) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int key : map.keySet()) {
            queue.offer(key);
        }

        while (!queue.isEmpty()) {
            int time = groupSize;
            List<Integer> list = new ArrayList<>();
            while (time-- != 0 && !queue.isEmpty()) {
                list.add(queue.poll());
            }

            if(time > -1) {
                return false;
            }

            for(int i = 0; i < list.size(); i++) {
                if(i > 0) {
                    if(list.get(i) - 1 != list.get(i - 1)) {
                        return false;
                    }
                }
                if(map.get(list.get(i)) - 1 != 0) {
                    map.put(list.get(i), map.get(list.get(i)) - 1);
                    queue.offer(list.get(i));
                }
            }
        }
        return true;
    }
}
