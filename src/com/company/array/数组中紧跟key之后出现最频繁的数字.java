package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 数组中紧跟key之后出现最频繁的数字
 * @Date 2022/3/6 12:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组中紧跟key之后出现最频繁的数字 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == key) {
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0) + 1);
            }
        }
        int max = 0;
        int res = 0;
        for(int v : map.keySet()) {
            if(map.get(v) > max) {
                max = map.get(v);
                res = v;
            }
        }
        return res;
    }
}
