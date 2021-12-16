package com.company.sort;

import java.util.PriorityQueue;

/**
 * @Classname 第K个最小的素数分数
 * @Date 2021/11/29 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 第K个最小的素数分数 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            double a = (double) arr[o1[0]] / arr[o1[1]];
            double b = (double) arr[o2[0]] / arr[o2[1]];
            return Double.compare(a, b);
        });
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                queue.add(new int[]{i, j});
            }
        }

        while (k != 1) {
            queue.poll();
            k--;
        }

        return new int[]{arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }
}
