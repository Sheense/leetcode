package com.company.queue;

import java.util.PriorityQueue;

public class 连续中值 {
    class MedianFinder {

        private PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> o2 - o1);
        private PriorityQueue<Integer> min = new PriorityQueue<>();
        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if(max.size() == min.size()) {
                if(max.isEmpty()) {
                    max.offer(num);
                }else {
                    if(num<= min.peek()) {
                        max.offer(num);
                    }else {
                        int item = min.poll();
                        max.offer(item);
                        min.offer(num);
                    }
                }
            }else {
                max.offer(num);
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if(max.size() > min.size()) {
                return max.peek();
            }else {
                return ((double) max.peek() + min.peek())/2;
            }
        }
    }
}
