package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 好数对的数目 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res =0;
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                res += map.get(nums[i]);
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }

        }
        return res;
    }
}
