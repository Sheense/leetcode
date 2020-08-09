package com.company.array;

import java.util.*;

public class 和为目标值的最大数目不重叠非空子数组数目 {
    public static void main(String[] args) {
        和为目标值的最大数目不重叠非空子数组数目 s = new 和为目标值的最大数目不重叠非空子数组数目();
        System.out.println(s.maxNonOverlapping(new int[]{0,0,0},0));
    }
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> need = new HashMap<>();
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i>0) {
                arr[i] = arr[i-1] + nums[i];
            }else {
                arr[i] = nums[i];
            }
            int n = arr[i] - target;
            if(map.containsKey(n)) {
                need.put(i, new ArrayList<>(map.get(n)));
            }
            map.computeIfAbsent(arr[i], x->new ArrayList<>()).add(i);
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(arr[i] == target) dp[i] = 1;
            if(i==0) continue;
            if(need.containsKey(i)) {
                for(int j : need.get(i)) {
                    if(arr[i] - arr[j]==target) {//j+1 到i 为target,
                        dp[i] =  Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
            if(dp[i]>max) {
                max = dp[i];
            }
        }
        return max;
    }


}
