package com.company.queue;

import java.util.PriorityQueue;

/**
 * @Classname 数据流的中位数
 * @Date 2021/8/27 12:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        s.addNum(1);
        s.addNum(2);
        s.findMedian();
        s.addNum(3);
        s.findMedian();
    }
    static class MedianFinder {
        private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        private PriorityQueue<Integer> min = new PriorityQueue<>();
        private int size = 0;
        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            size++;
            if(size == 1) {
                max.add(num);
                return;
            }
            if(max.isEmpty() || max.peek() >= num) {
                max.add(num);
            }else {
                min.add(num);
            }
            process();
        }

        private void process() {
            if(max.size() > min.size()) {
                while (max.size() - min.size() > 1) {
                    min.add(max.poll());
                }
            }else {
                while (min.size() - max.size() > 0) {
                    max.add(min.poll());
                }
            }
        }

        public double findMedian() {
            if(size % 2 == 0) {
                return ((double) max.peek() + min.peek()) / 2;
            }else {
                return max.peek();
            }
        }
    }
}
