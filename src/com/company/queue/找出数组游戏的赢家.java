package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class 找出数组游戏的赢家 {
    public static void main(String[] args) {
        找出数组游戏的赢家 s = new 找出数组游戏的赢家();
        System.out.println(s.getWinner(new int[]{1,25,35,42,68,70}, 1));
    }
    public int getWinner(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int max = arr[0];
        for(int i=0;i<arr.length;i++) {
            queue.offer(arr[i]);
            if(max<arr[i]) max = arr[i];
        }
        int win = 0;
        int first = queue.poll();
        while(true) {
            if(first==max) {
                break;
            }
            if(first>queue.peek()) {
                win ++;
                if(win==k) break;
                queue.offer(queue.poll());
            } else {
                win = 1;
                queue.offer(first);
                first = queue.poll();
                if(win == k) break;
            }
        }
        return first;
    }
}
