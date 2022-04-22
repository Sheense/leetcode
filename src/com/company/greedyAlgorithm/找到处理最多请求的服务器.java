package com.company.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @Classname 找到处理最多请求的服务器
 * @Date 2022/3/30 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到处理最多请求的服务器 {
    public static void main(String[] args) {
        找到处理最多请求的服务器 s = new 找到处理最多请求的服务器();
        System.out.println(s.busiestServers(7, new int[]{1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32}, new int[]{9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6}));
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] res = new int[k];
        TreeSet<Integer> free = new TreeSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for(int i = 0; i < k; i++) {
            free.add(i);
        }
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            int cost = load[i];
            while (!queue.isEmpty() && queue.peek()[0] <= start) {
                int[] item = queue.poll();
                free.add(item[1]);
            }
            if(!free.isEmpty()) {
                int target = i % k;
                Integer index = free.ceiling(target);
                if(index != null) {
                    free.remove(index);
                    res[index]++;
                    queue.offer(new int[]{start+cost, index});
                }else {
                    index = free.ceiling(0);
                    free.remove(index);
                    res[index]++;
                    queue.offer(new int[]{start+cost, index});
                }
                if(res[index] >= max) {
                    if(res[index] > max) {
                        max = res[index];
                        ans = new ArrayList<>();
                    }
                    ans.add(index);
                }
            }
        }

        return ans;
    }
}
