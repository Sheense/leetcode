package com.company.bfs;

import java.util.*;

/**
 * @Classname 跳跃游戏IV
 * @Date 2022/1/21 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 跳跃游戏IV {
    public static void main(String[] args) {
        跳跃游戏IV s = new 跳跃游戏IV();
        System.out.println(s.minJumps(new int[]{6,1,9}));
    }
    public int minJumps(int[] arr) {
        boolean[] check = new boolean[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                int index = queue.poll();
                check[index] = true;
                if(index == arr.length - 1) {
                    return res;
                }
                Set<Integer> set = new HashSet<>();
                if(map.containsKey(arr[index])) {
                    for(int next : map.get(arr[index])) {
                        if(next != index && !check[next]) {
                            set.add(next);
                            queue.add(next);
                        }
                    }
                    map.remove(arr[index]);
                }
                if(index - 1 >= 0 && !check[index - 1] && !set.contains(index - 1)) {
                    queue.offer(index - 1);
                }
                if(index + 1 < arr.length && !check[index + 1 ] && !set.contains(index + 1)) {
                    queue.offer(index + 1 );
                }
            }
            res++;
        }
        return res;
    }
}
