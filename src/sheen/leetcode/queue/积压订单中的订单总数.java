package sheen.leetcode.queue;

import java.util.PriorityQueue;

public class 积压订单中的订单总数 {
    public static void main(String[] args) {
        积压订单中的订单总数 s = new 积压订单中的订单总数();
        System.out.println(s.getNumberOfBacklogOrders(new int[][]{{16,24,0},{16,2,1},{23,28,1},{21,6,0},{17,8,0},{25,7,0}}));
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Integer> buy = new PriorityQueue<>((o1, o2) -> orders[o2][0] - orders[o1][0]);
        PriorityQueue<Integer> sell = new PriorityQueue<>((o1, o2) -> orders[o1][0] - orders[o2][0]);

        for(int i=0;i<orders.length;i++) {
            if (orders[i][2] == 0) {
               while (!sell.isEmpty() && orders[sell.peek()][0] <= orders[i][0]&&orders[i][1]>0) {
                   int min = sell.poll();
                   if (orders[min][1] > orders[i][1]) {
                       orders[min][1] -= orders[i][1];
                       orders[i][1] = 0;
                       sell.offer(min);
                   }else {
                       orders[i][1] -= orders[min][1];
                       orders[min][1] = 0;
                   }
               }
               if(orders[i][1] > 0) {
                   buy.offer(i);
               }
            } else {
                while (!buy.isEmpty() && orders[buy.peek()][0] >= orders[i][0]&&orders[i][1]>0) {
                    int max = buy.poll();
                    if (orders[max][1] > orders[i][1]) {
                        orders[max][1] -= orders[i][1];
                        orders[i][1] = 0;
                        buy.offer(max);
                    }else {
                        orders[i][1] -= orders[max][1];
                        orders[max][1] = 0;
                    }
                }
                if(orders[i][1] > 0) {
                    sell.offer(i);
                }
            }
        }
        long res = 0;
        while (!buy.isEmpty()) {
            res += orders[buy.poll()][1];
        }
        while (!sell.isEmpty()) {
            res += orders[sell.poll()][1];
        }
        return (int)(res % ((int)Math.pow(10, 9) + 7));
    }
}
