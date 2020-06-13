package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {

    class MaxQueue {

        private Queue<Integer> queue;
        //单调递减队列
        private Queue<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            if(maxQueue.isEmpty()) return -1;
            return maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            if(queue.isEmpty()) {
                maxQueue.offer(value);
            }else {
                Queue<Integer> item = new LinkedList<>();
                while(!maxQueue.isEmpty()&&maxQueue.peek()>=value) {
                    item.offer(maxQueue.poll());
                }
                item.offer(value);
                maxQueue = item;
            }
        }

        public int pop_front() {
            if(queue.isEmpty()) return -1;
            int item = queue.poll();
            if(item == maxQueue.peek()) {
                maxQueue.poll();
            }
            return item;
        }
    }
}
