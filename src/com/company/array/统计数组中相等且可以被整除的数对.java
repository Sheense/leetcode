package com.company.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 统计数组中相等且可以被整除的数对
 * @Date 2022/2/19 10:42 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计数组中相等且可以被整除的数对 {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int res = 0;
        for(int i : map.keySet()) {
            for(int j = 0; j < map.get(i).size() - 1; j++) {
                for(int z = j + 1; z < map.get(j).size(); z++) {
                    if((map.get(i).get(j) * map.get(i).get(z))  % k == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
