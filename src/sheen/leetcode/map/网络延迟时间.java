package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 网络延迟时间
 * @Date 2021/8/2 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 网络延迟时间 {
    public static void main(String[] args) {
        网络延迟时间 s = new 网络延迟时间();
        System.out.println(s.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4 ,2));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < times.length; i++) {
            map.computeIfAbsent(times[i][0], x -> new HashMap<>()).put(times[i][1], times[i][2]);
        }
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        set.add(k);
        arr[k] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> arr[x] - arr[y]);
        Map<Integer, Integer> m = map.getOrDefault(k, new HashMap<>());
        for(int key: m.keySet()) {
            arr[key] = m.get(key);
            queue.add(key);
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if(set.contains(index)) continue;
            set.add(index);
            Map<Integer, Integer> temp = map.getOrDefault(index, new HashMap<>());
            int len = arr[index];
            for (int key : temp.keySet()) {
                arr[key] = Math.min(arr[key], len + temp.get(key));
                queue.offer(key);
            }
        }
        int max = 0;
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return set.size() == n  ? max : -1;
    }



}
