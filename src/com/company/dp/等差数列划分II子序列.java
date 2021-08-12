package com.company.dp;

import java.util.*;

/**
 * @Classname 等差数列划分II子序列
 * @Date 2021/8/11 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 等差数列划分II子序列 {
    public static void main(String[] args) {
        等差数列划分II子序列 s = new 等差数列划分II子序列();
        System.out.println(s.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Map<Long, Map<Integer, Integer>>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            Map<Long, Map<Integer,Integer>> item = new HashMap<>();
            for(int j = i - 1; j >= 0; j--) {
                long key = (long)nums[i] - nums[j];
                if(map.get(j).containsKey(key)) {
                    Map<Integer, Integer> arr = map.get(j).get(key);
                    Map<Integer, Integer> a = item.computeIfAbsent(key, x -> new HashMap<>());
                    for(int z : arr.keySet()) {
                        a.put(z+1, a.getOrDefault(z+1, 0) + arr.get(z));
                    }
                }
                Map<Integer, Integer> a = item.computeIfAbsent(key, x -> new HashMap<>());
                a.put(2, a.getOrDefault(2, 0) + 1);
            }
            map.put(i, item);
        }


        for(int i = nums.length - 1; i >= 0; i--){
            for(long key : map.get(i).keySet()) {
                for(int j : map.get(i).get(key).keySet()) {
                    if(j >= 3) res += map.get(i).get(key).get(j);
                }
            }
        }
        return res;
    }
}
