package com.company.bfs;

import java.util.*;

/**
 * @Classname K站中转内最便宜的航班
 * @Date 2021/8/24 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class K站中转内最便宜的航班 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < flights.length; i++) {
            int arr[] = {flights[i][1], flights[i][2]};
            map.computeIfAbsent(flights[i][0], x -> new ArrayList<>()).add(arr);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        //保留起点到i的最小花费
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        //中转不超过k个点，最多可以移动k+1次
        while (k-- >= 0) {
            int size = queue.size();
            while (size-- != 0) {
                int[] arr = queue.poll();
                List<int[]> list = map.get(arr[0]);
                int cost = arr[1];
                if(list != null) {
                    for(int[] item : list) {
                        //剪枝
                        if(costs[item[0]] > item[1] + cost) {
                            costs[item[0]] = item[1] + cost;
                            queue.offer(new int[]{item[0], item[1] + cost});
                        }
                    }
                }
            }
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
