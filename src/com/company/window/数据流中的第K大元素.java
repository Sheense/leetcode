package com.company.window;

import java.util.PriorityQueue;

public class 数据流中的第K大元素 {

    public static void main(String[] args) {
        PriorityQueue<Integer> small = new PriorityQueue<>((o1,o2)-> o2-o1);
        small.add(4);
        small.add(2);
        small.add(5);
        small.add(3);
        System.out.println(small.peek());
        System.out.println(small.poll());
        System.out.println(small);
    }
    class KthLargest {
        private PriorityQueue<Integer> queue ;
        private int k = 0;
        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            this.k = k;
            for(int i=0;i<nums.length;i++) {
                if(queue.size()<k) {
                    queue.add(nums[i]);
                }else {
                    if(queue.peek()<nums[i]) {
                        queue.add(nums[i]);
                        queue.poll();
                    }
                }
            }
        }

        public int add(int val) {
            if(queue.size()<k) {
                queue.add(val);

            }else if(val>queue.peek()) {
                queue.add(val);
                queue.poll();
            }
            return queue.peek();
        }
    }
}
