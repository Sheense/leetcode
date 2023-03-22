package sheen.leetcode.map;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname 细分图中的可到达结点
 * @Date 2022/11/26 2:46 下午
 * @Created by sheen
 * @Description TODO
 */
public class 细分图中的可到达结点 {
    public static void main(String[] args) {
        /*细分图中的可到达结点 s = new 细分图中的可到达结点();
        System.out.println(s.reachableNodes(new int[][]{{1,2,5},{0,3,3},{1,3,2},{2,3,4},{0,4,1}}, 7 ,5));*/
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        queue.offer(new int[]{0, 0});
        int[][] points = new int[n][n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new HashSet<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new HashSet<>()).add(edges[i][0]);
            points[edges[i][0]][edges[i][1]] = edges[i][2];
            points[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        boolean[] adv = new boolean[n];
        Set<Integer> view = new HashSet<>();
        int[][] viewPoint = new int[n][n];
        while (!queue.isEmpty() && queue.peek()[0] <= maxMoves) {
            int[] item = queue.poll();
            int moves = item[0];
            Set<Integer> nextSet = map.get(item[1]);
            if(view.contains(item[1])) {
                continue;
            }
            view.add(item[1]);
            adv[item[1]] = true;
            if(nextSet == null) {
                continue;
            }
            for(int next : nextSet) {
                int count = points[item[1]][next] + moves;
                viewPoint[item[1]][next] = Math.max(viewPoint[item[1]][next], count <= maxMoves ? points[item[1]][next] : maxMoves - moves);
                queue.offer(new int[]{count + 1, next});
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(adv[i]) {
                res ++;
            }
        }
        for(int i = 0; i < edges.length; i++) {
            res += Math.min(viewPoint[edges[i][0]][edges[i][1]] + viewPoint[edges[i][1]][edges[i][0]], edges[i][2]);
        }

        return res;
    }
}
