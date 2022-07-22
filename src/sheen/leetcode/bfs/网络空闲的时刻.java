package sheen.leetcode.bfs;


import java.util.*;

/**
 * @Classname 网络空闲的时刻
 * @Date 2022/3/20 1:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 网络空闲的时刻 {
    public static void main(String[] args) {
        网络空闲的时刻 s = new 网络空闲的时刻();
        System.out.println(s.networkBecomesIdle(new int[][]{{0,1},{0,2},{1,2}}, new int[]{0, 10, 10}));
    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int[] res = new int[patience.length];
        Arrays.fill(res, - 1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(edges[i][0]);
        }

        bfs(map, res);
        int ans = 0;
        for(int i = 1; i < patience.length; i++) {
            int cost = patience[i] * ((2 * res[i] - 1) / patience[i]) + 2 * res[i] + 1;
            ans = Math.max(cost, ans);
        }
        return ans;
    }

    public void bfs(Map<Integer, List<Integer>> map, int[] res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int index = queue.poll();
                res[index] = res[index] == -1 ? count : res[index];
                for(int i : map.getOrDefault(index, new ArrayList<>())) {
                    if(res[i] == -1) {
                        queue.offer(i);
                    }
                }
            }
            count ++;
        }
    }
}
