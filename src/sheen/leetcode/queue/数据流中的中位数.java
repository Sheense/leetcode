package sheen.leetcode.queue;

import java.util.PriorityQueue;

public class 数据流中的中位数 {
    class MedianFinder {

        private PriorityQueue<Double> small;//小的元素
        private PriorityQueue<Double> large;
        /** initialize your data structure here. */
        public MedianFinder() {
            small = new PriorityQueue<>((o1,o2)->o2-o1<0?-1:1);
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(small.size()==0) {
                small.add((double)num);
            }else {
                if(small.peek()>=num){
                    small.add((double)num);
                }else {
                    large.add((double)num);
                }
                if(small.size()-large.size()==2) {
                    large.add(small.poll());
                }else if(large.size()-small.size()==1) {
                    small.add(large.poll());
                }
            }

        }

        public double findMedian() {
            if((small.size()+large.size())%2==1) {
                return small.peek();
            }else {
                return (small.peek()+large.peek())/2;
            }
        }
    }
}
