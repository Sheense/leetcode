package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 连续数组 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        nums[0] = nums[0]==1?1:-1;
        map.put(nums[0], 0);
        int res = 0;
        for(int i = 1;i<nums.length;i++) {
            nums[i] = nums[i-1] + (nums[i] == 1 ? 1: -1);
            if(nums[i] == 0) {
                res = Math.max(res, i+1);
            }else if(map.containsKey(nums[i])) {
                res = Math.max(res, i - map.get(nums[i]));
            }else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
