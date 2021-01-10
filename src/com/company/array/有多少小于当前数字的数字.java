package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res  = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=nums[i]-1;j>=0;j--) {
                res[i] += map.getOrDefault(j ,0);
            }
        }
        return res;
    }
}
