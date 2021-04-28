package com.company.number;

import java.util.LinkedList;
import java.util.Queue;

public class 笨阶乘 {
    public static void main(String[] args) {
        笨阶乘 s = new 笨阶乘();
        System.out.println(s.clumsy(10));
    }
    public int clumsy(int N) {
        Queue<Long> queue = new LinkedList<>();
        while(N>=1) {
            long item = N;
            N--;
            for(int i=0;i<2&&N>=1;i++) {
                switch (i) {
                    case 0: item *= N;break;
                    case 1: item /= N;break;
                }
                N--;
            }
            queue.offer(item);

            if(N>=1) {
                queue.offer((long)N);
                N--;
            }
        }
        long res = queue.poll();
        while (!queue.isEmpty()) {
            res += queue.poll();
            if(!queue.isEmpty()) res -= queue.poll();
        }
        return (int)res;
    }
}
