package com.company.bfs;

import java.util.*;

/**
 * @Classname 为高尔夫比赛砍树
 * @Date 2022/5/23 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 为高尔夫比赛砍树 {
    public static void main(String[] args) {
        为高尔夫比赛砍树 s = new 为高尔夫比赛砍树();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(54581641,64080174,24346381,69107959));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(86374198,61363882,68783324,79706116));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(668150,92178815,89819108,94701471));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(83920491,22724204,46281641,47531096));
        List<Integer> l5 = new ArrayList<>(Arrays.asList(89078499,18904913,25462145,60813308));

        List<List<Integer>> l = new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        System.out.println(s.cutOffTree(l));
    }
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.get(0).size();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> forest.get(x / n).get(x % n) - forest.get(y / n).get(y % n));
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                if(forest.get(i).get(j) > 1) {
                    queue.offer(i * n + j);
                }
            }
        }

        int res = 0;
        int start = 0;
        while (!queue.isEmpty()) {
            int end = queue.poll();
            int count = bfs(start, end, forest);
            if(count == -1) {
                return -1;
            }
            res += count;
            start = end;
        }

        return res;
    }

    public int bfs(int start, int end, List<List<Integer>> forest) {
        int[][] arr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = forest.size();
        int cols = forest.get(0).size();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int point = queue.poll();
                if(point == end) {
                    return count;
                }
                int x = point / cols;
                int y = point % cols;
                for(int i = 0; i < arr.length; i++) {
                    int newX = x + arr[i][0];
                    int newY = y + arr[i][1];
                    int newPoint = newX * cols + newY;
                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols
                      && !set.contains(newPoint)
                      && forest.get(newX).get(newY) > 0) {
                        queue.offer(newPoint);
                        set.add(newPoint);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
