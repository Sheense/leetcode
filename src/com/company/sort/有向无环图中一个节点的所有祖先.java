package com.company.sort;

import java.util.*;

/**
 * @Classname 有向无环图中一个节点的所有祖先
 * @Date 2022/3/6 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有向无环图中一个节点的所有祖先 {
    public static void main(String[] args) {
        有向无环图中一个节点的所有祖先 s= new 有向无环图中一个节点的所有祖先();
        System.out.println(s.getAncestors(8, new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, Set<Integer>> res = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> parent = new HashMap<>();
        int[] arr = new int[n];
        for(int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], x -> new ArrayList<>()).add(edges[i][1]);
            parent.computeIfAbsent(edges[i][1], x -> new HashSet<>()).add(edges[i][0]);
            arr[edges[i][1]] ++;
        }

        System.out.println(map);
        System.out.println(parent);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int index = queue.poll();
                Set<Integer> parentSet = parent.getOrDefault(index, new HashSet<>());
                if(parentSet.size() > 0) {
                    Set<Integer> r = new HashSet<>();
                    for(int i : parentSet) {
                        r.add(i);
                        r.addAll(res.get(i));
                    }
                    res.put(index, r);
                }else {
                    res.put(index, new HashSet<>());
                }
                List<Integer> child = map.getOrDefault(index, new ArrayList<>());
                for(int i : child) {
                    arr[i] --;
                    if(arr[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(res.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        return ans;

    }
}
