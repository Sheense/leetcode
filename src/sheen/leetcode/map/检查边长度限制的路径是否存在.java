package sheen.leetcode.map;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Classname 检查边长度限制的路径是否存在
 * @Date 2022/12/14 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查边长度限制的路径是否存在 {
    public static void main(String[] args) {
        检查边长度限制的路径是否存在 s = new 检查边长度限制的路径是否存在();
        ArrayUtils.print(s.distanceLimitedPathsExist(5, new int[][]{{0,1,10},{1,2,5},{2,3,9},{3,4,13}},
                new int[][]{{0,4,14},{1,4,13}}));
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionSet unionSet = new UnionSet(n);
        Arrays.sort(edgeList, (x, y) -> x[2] - y[2]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        for(int i = 0; i < queries.length; i++) {
            priorityQueue.add(new int[]{queries[i][0], queries[i][1], queries[i][2], i});
        }

        boolean[] res = new boolean[queries.length];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            int[] query = priorityQueue.poll();
            int a = query[0];
            int b = query[1];
            int limit = query[2];
            int index = query[3];
            while (i < edgeList.length && edgeList[i][2] < limit) {
                unionSet.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            res[index] = unionSet.hasEdge(a, b);
        }

        return res;
    }

    public static class UnionSet{
        private int[] parent;
        public UnionSet(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int r1 = findRoot(a);
            int r2 = findRoot(b);
            if(r1 != r2) {
                merge(r1, b);
            }
        }

        private void merge(int r, int a) {
            while (a != parent[a]) {
                int next = parent[a];
                parent[a] = r;
                a = next;
            }
            parent[a] = r;
        }

        private int findRoot(int a) {
            while (a != parent[a]) {
                a = parent[a];
            }

            return a;
        }

        public boolean hasEdge(int a, int b) {
            return findRoot(a) == findRoot(b);
        }
    }
}
