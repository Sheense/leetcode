package com.company.dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 跳跃游戏VI {
    public int maxResult(int[] nums, int k) {
        int [] dp = new int[nums.length];
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(int i=0;i<nums.length;i++) {
            if (i==0) {
                dp[i] = nums[0];
                q.add(new int[]{0, dp[0]});
            } else {
                while(q.peek()[0]<i-k){
                    q.poll();
                }
                dp[i] = q.peek()[1] + nums[i];
                q.add(new int[]{i, dp[i]});
            }
        }
        return dp[nums.length-1];
    }
}
