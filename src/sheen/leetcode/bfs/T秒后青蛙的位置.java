package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname T秒后青蛙的位置
 * @Date 2023/5/24 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class T秒后青蛙的位置 {
    public static void main(String[] args) {
        T秒后青蛙的位置 s = new T秒后青蛙的位置();
        //System.out.println(s.frogPosition(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 1, 7));
        System.out.println(s.frogPosition(7, new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}}, 2, 4));
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Queue<double[]> queue = new LinkedList<>();
        Queue<Set<Double>> queueSet = new LinkedList<>();
        Map<Double, List<Double>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent((double)edges[i][0], x -> new ArrayList<>()).add((double)edges[i][1]);
            map.computeIfAbsent((double)edges[i][1], x -> new ArrayList<>()).add((double)edges[i][0]);
        }

        if(!map.containsKey(1.0)) {
            if(target == 1) {
                return 1.0;
            }
            return 0;
        }
        queue.offer(new double[]{1, 1});
        queueSet.offer(new HashSet<>(Arrays.asList(1.0)));
        int i = 0;
        double res = 0;
        while (i < t && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                double[] arr = queue.poll();
                Set<Double> set = queueSet.poll();
                int count = 0;
                for(double next : map.get(arr[0])) {
                    if(!set.contains(next)) {
                        count++;
                    }
                }

                if(count == 0 && arr[0] == target) {
                    res += arr[1];
                    continue;
                }

                for(double next : map.get(arr[0])) {
                    if(!set.contains(next)) {
                        queue.offer(new double[]{next, arr[1] * (1.0 / count)});
                        Set<Double> nextSet = new HashSet<>(set);
                        nextSet.add(next);
                        queueSet.offer(nextSet);
                    }
                }

            }

            i++;
        }

        while (!queue.isEmpty()) {
            double[] arr = queue.poll();
            if(arr[0] == target) {
                res += arr[1];
            }
        }
        return res;
    }
}
