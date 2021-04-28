package com.company.hashmap;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _132模式 {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=1;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int min = nums[0];
        for(int i = 1;i<nums.length;i++) {
            if(map.get(nums[i]) == 1) map.remove(nums[i]);
            else map.put(nums[i], map.get(nums[i])-1);
            if(min<nums[i]) {
                //ceilingKey返回大于等于给定值的最小值
               Integer next = map.ceilingKey(min + 1);
               if(next!=null && next < nums[i]) {
                   return true;
               }
            } else {
               min = nums[i];
            }
        }
        return false;
    }
}
