package sheen.leetcode.queue;

import java.util.*;

/**
 * @Classname 受限条件下可到达节点的数目
 * @Date 2022/8/7 10:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 受限条件下可到达节点的数目 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int res = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x -> new ArrayList<>()).add(edges[i][0]);
        }
        Set<Integer> restrictedSet = new HashSet<>();
        for(int i = 0; i < restricted.length; i++) restrictedSet.add(restricted[i]);
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        set.add(0);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--!=0) {
                int v = queue.poll();
                List<Integer> list = map.get(v);
                if(list != null) {
                    for(int item : list) {
                        if(!set.contains(item) && !restrictedSet.contains(item)) {
                            queue.offer(item);
                            set.add(item);
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }
}
