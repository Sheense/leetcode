package com.company.greedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 课程表III
 * @Date 2021/12/14 12:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 课程表III {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> courses[y][0] - courses[x][0]);
        int now = 0;
        for(int i = 0; i < courses.length; i++) {
            if(now + courses[i][0] <= courses[i][1]) {
                queue.offer(i);
                now += courses[i][0];
            }else if(!queue.isEmpty() && courses[queue.peek()][0] > courses[i][0]) {
                now -= courses[queue.peek()][0] - courses[i][0];
                queue.poll();
                queue.offer(i);
            }
        }
        return queue.size();
    }
}
