package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 和相同的二元子数组 {
    public static void main(String[] args) {
        和相同的二元子数组 s = new 和相同的二元子数组();
        System.out.println(s.numSubarraysWithSum(new int[]{1,0,1,0,1},2));
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int all = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            all += nums[i];
            if(all == goal) {
                res++;
            }
            int num = all - goal;
            int count = map.getOrDefault(num, 0);
            res += count;
            map.put(all, map.getOrDefault(all, 0) + 1);
        }
        return res;
    }
}
