package sheen.leetcode.queue;

import java.util.*;

public class 天际线问题 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> boundaries = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++) {
            boundaries.add(buildings[i][0]);
            boundaries.add(buildings[i][1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(boundaries);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int n = buildings.length;
        int index = 0;
        for(int boundary : boundaries) {
            while (index < n && buildings[index][0] <= boundary) {
                queue.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }

            while (!queue.isEmpty() && queue.peek()[0] <= boundary) {
                queue.poll();
            }

            int maxH = queue.isEmpty() ? 0 : queue.peek()[1];
            if(res.size() == 0 || res.get(res.size()- 1).get(1) != maxH) {
                res.add(Arrays.asList(boundary, maxH));
            }
        }
        return res;
    }
}
