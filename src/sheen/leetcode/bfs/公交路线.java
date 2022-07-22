package sheen.leetcode.bfs;

import java.util.*;

public class 公交路线 {
    public static void main(String[] args) {
        公交路线 s = new 公交路线();
        System.out.println(s.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 1, 6));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        List<Set<Integer>> buses = new ArrayList<>();
        List<Integer> sources = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j<routes[i].length; j++) {
                set.add(routes[i][j]);
                map.computeIfAbsent(routes[i][j], x -> new HashSet<>()).add(i);
            }
            buses.add(set);
            if(set.contains(source)) {
                sources.add(i);
            }
        }
        int[] ans = new int[sources.size()];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i = 0; i < sources.size(); i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(sources.get(i));
            int res = 1;
            Set<Integer> set = new HashSet<>();
            set.add(sources.get(i));
            boolean flag = false;
            while (!queue.isEmpty() && flag == false) {
                int size = queue.size();
                while (size-- != 0) {
                    int index = queue.poll();
                    if(buses.get(index).contains(target)) {
                        ans[i] = res;
                        flag = true;
                        break;
                    }
                    for(int stop : buses.get(index)) {
                        for(int nextBudIndex : map.get(stop)) {
                            if(!set.contains(nextBudIndex)) {
                                set.add(nextBudIndex);
                                queue.offer(nextBudIndex);
                            }
                        }
                    }
                }
                res ++;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ans.length; i++) {
            min = Math.min(min, ans[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
