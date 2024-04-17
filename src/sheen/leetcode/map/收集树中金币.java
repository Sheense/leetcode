package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 收集树中金币
 * @Date 2023/9/21 00:29
 * @Created by sheen
 * @Description TODO
 */
public class 收集树中金币 {
    public static void main(String[] args) {
        收集树中金币 s = new 收集树中金币();
       System.out.println(s.collectTheCoins(new int[]{1,0,0,0,0,1},new int[][]{{0,1},{1,2},{2,3},{3,4},{4,5}}));
       System.out.println(s.collectTheCoins(new int[]{0,0,0,1,1,0,0,1}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{5,6},{5,7}}));
        System.out.println(s.collectTheCoins(new int[]{1,0,0,1},
                new int[][]{{0,1},{1,2},{2,3}}));

    }
    public int collectTheCoins(int[] coins, int[][] edges) {

        int[] du = new int[coins.length];
        List<Integer>[] list = new List[coins.length];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
            du[edge[0]]++;
            du[edge[1]]++;
        }

        int rest = coins.length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < du.length; i++) {
            if(du[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --!= 0) {
                int index = queue.poll();
                if(coins[index] == 0) {
                    rest--;
                    du[index]--;
                    for(int v : list[index]) {
                        du[v]--;
                        if(du[v] == 1) {
                            queue.offer(v);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < 2; i++) {
            queue = new LinkedList<>();
            for(int j = 0; j < coins.length; j++) {
                if(du[j] == 1) {
                    queue.offer(j);
                }
            }

            while (!queue.isEmpty()) {
                int index = queue.poll();
                rest--;
                du[index]--;
                for(int v : list[index]) {
                    du[v]--;
                }
            }
        }
        return rest == 0 ? 0 : (rest - 1) * 2;
    }



}
