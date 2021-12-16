package com.company.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Classname 两个最好的不重叠活动
 * @Date 2021/10/30 11:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 两个最好的不重叠活动 {
    public static void main(String[] args) {
        两个最好的不重叠活动 s= new 两个最好的不重叠活动();
        System.out.println(s.maxTwoEvents(new int[][]{{1,3,2},{4,5,2},{2,4,3}}));
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if(a[1] != b[1]) {
                return b[1] - a[1];
            }
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        int res = 0;
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> events[b][0] - events[a][0]);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> events[b][2] - events[a][2]);
        for(int i = 0; i < events.length; i++) {
            while (!left.isEmpty() && events[left.peek()][0] > events[i][1]) {
                max.offer(left.poll());
            }
            res = max.isEmpty() ? Math.max(res, events[i][2]) : Math.max(res, events[i][2] + events[max.peek()][2]);
            left.offer(i);
        }
        return res;
    }
}
