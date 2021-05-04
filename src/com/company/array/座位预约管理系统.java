package com.company.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class 座位预约管理系统    {
    class SeatManager {

        private PriorityQueue<Integer> queue = new PriorityQueue();
        public SeatManager(int n) {
            for(int i=1;i<=n;i++) {
                queue.offer(i);
            }
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.offer(seatNumber);
        }
    }
}
