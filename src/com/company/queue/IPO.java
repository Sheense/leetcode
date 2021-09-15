package com.company.queue;

import java.util.PriorityQueue;

/**
 * @Classname IPO
 * @Date 2021/9/8 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class IPO {
    public static void main(String[] args) {
        IPO s = new IPO();
        //System.out.println(s.findMaximizedCapital(2,0,));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> profits[o2] - profits[o1]);
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> capital[o1] - capital[o2]);
        for(int i = 0; i < profits.length; i++) {
            if(capital[i] > w) {
                min.offer(i);
            }else {
                max.offer(i);
            }
        }
        for(int i = 0; i < k&&!max.isEmpty(); i++) {
            int index = max.poll();
            w += profits[index];
            while (!min.isEmpty() && capital[min.peek()] <= w) {
                max.offer(min.poll());
            }
        }
        return w;
    }
}
