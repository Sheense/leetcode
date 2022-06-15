package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 替换数组中的元素
 * @Date 2022/6/5 11:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 替换数组中的元素 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = operations.length -1; i >= 0; i--) {
            if(map.containsKey(operations[i][1])) {
                map.put(operations[i][0], map.get(operations[i][1]));
            }else {
                map.put(operations[i][0], operations[i][1]);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(nums[i], nums[i]);
        }

        return nums;
    }
}
