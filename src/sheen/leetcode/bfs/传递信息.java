package sheen.leetcode.bfs;

import java.util.*;

public class 传递信息 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < relation.length; i++) {
            map.computeIfAbsent(relation[i][0], x -> new ArrayList<>()).add(relation[i][1]);
        }

        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int num = queue.poll();
                for(int value : map.getOrDefault(num, new ArrayList<>())) {
                    queue.offer(value);
                }
            }
            time++;
            if(time == k) {
                int res = 0;
                while (!queue.isEmpty()) {
                    if(queue.poll() == n-1) {
                        res++;
                    }
                }
                return res;
            }
        }
        return 0;
    }
}
