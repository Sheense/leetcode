package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 设计可以求最短路径的图类
 * @Date 2024/3/26 00:13
 * @Created by sheen
 * @Description TODO
 */
public class 设计可以求最短路径的图类 {
    static class Graph {

        private List<int[]>[] list;
        private int n ;
        public Graph(int n, int[][] edges) {
            this.n = n;
            this.list = new List[n];
            for(int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
            }

            for(int[] edge : edges) {
                list[edge[0]].add(new int[]{edge[1], edge[2]});
            }
        }

        public void addEdge(int[] edge) {
            list[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
            int[] dict = new int[n];
            Arrays.fill(dict, Integer.MAX_VALUE);
            dict[node1] = 0;
            queue.offer(new int[]{0, node1});
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                if(point[1] == node2) {
                    return point[0];
                }

                for(int[] arr : list[point[1]]) {
                    if(arr[1] + point[0] < dict[arr[0]]) {
                        dict[arr[0]] = arr[1] + point[0];
                        queue.offer(new int[]{dict[arr[0]], arr[0]});
                    }
                }
            }

            return -1;
        }
    }
}
