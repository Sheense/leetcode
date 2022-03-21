package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 将数组划分成相等数对
 * @Date 2022/3/19 10:55 下午
 * @Created by sheen
 * @Description TODO
 */
public class 将数组划分成相等数对 {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
