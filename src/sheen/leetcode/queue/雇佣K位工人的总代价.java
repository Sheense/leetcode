package sheen.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @Classname 雇佣K位工人的总代价
 * @Date 2024/5/1 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 雇佣K位工人的总代价 {
    public static void main(String[] args) {
        雇佣K位工人的总代价 s = new 雇佣K位工人的总代价();
        System.out.println(s.totalCost(new int[]{57,33,26,76,14,67,24,90,72,37,30}, 11, 2));
    }
    public long totalCost(int[] costs, int k, int candidates) {
        int left = 0;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>((x, y) -> costs[x] - costs[y]);
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>((x, y) -> costs[x] - costs[y]);
        for(;left < Math.min(candidates, costs.length); left++) {
            leftQueue.offer(left);
        }
        int right = costs.length - 1;
        for(;right >= Math.max(left, costs.length - candidates); right--) {
            rightQueue.offer(right);
        }

        long res = 0;
        for(int i = 0; i < k; i++) {
            Integer l = leftQueue.peek();
            Integer r = rightQueue.peek();
            if(r == null || (l != null && costs[l] <= costs[r])) {
                res += costs[l];
                leftQueue.poll();
                if(left <= right) {
                    leftQueue.offer(left++);
                }
            }else {
                rightQueue.poll();
                res += costs[r];
                if(left <= right) {
                    rightQueue.offer(right--);
                }
            }
        }

        return res;
    }
}
