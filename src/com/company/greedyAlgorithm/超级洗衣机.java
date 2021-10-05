package com.company.greedyAlgorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname 超级洗衣机
 * @Date 2021/9/29 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 超级洗衣机 {
    public static void main(String[] args) {
        超级洗衣机 s = new 超级洗衣机();
        System.out.println(s.findMinMoves(new int[]{1,0,5}));
    }
    public int findMinMoves(int[] machines) {
        long all = 0;
        for(int i = 0; i < machines.length; i++) {
            all += machines[i];
        }
        if(all % machines.length > 0) {
            return -1;
        }
        int avg = (int)(all / machines.length);
        int max = 0;
        int sum = 0;
        for(int i = 0; i < machines.length; i++) {
            int num = machines[i] - avg;
            sum += num;
            max = Math.max(Math.max(Math.abs(sum), max), num);
        }

        return max;
    }
}
