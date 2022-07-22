package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 最小高度树
 * @Date 2022/4/6 12:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小高度树 {
    public static void main(String[] args) {
        最小高度树 s = new 最小高度树();
        System.out.println(s.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1) {
            ans.add(n);
            return ans;
        }
        List<Integer>[] list = new List[n];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findHeightNode(0, list, parent);
        int y = findHeightNode(x, list, parent);
        List<Integer> path = new ArrayList<>();
        while (y != x) {
            path.add(y);
            y = parent[y];
        }
        path.add(x);
        if(path.size() % 2 == 0) {
            ans.add(path.get(path.size() / 2 - 1));
        }
        ans.add(path.get(path.size()/2));
        return ans;
    }

    public int findHeightNode(int node, List<Integer>[] list, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        boolean[] check = new boolean[list.length];
        check[node] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = 0;
            while (size-- != 0) {
                index = queue.poll();
                for(int next : list[index]) {
                    if (!check[next]) {
                        parent[next] = index;
                        check[next] = true;
                        queue.offer(next);
                    }
                }
            }
            if(queue.isEmpty()) {
                return index;
            }
        }
        return -1;
    }


}
