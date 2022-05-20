package com.company.map;

import java.util.TreeMap;

/**
 * @Classname 寻找右区间
 * @Date 2022/5/20 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 寻找右区间 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            int right = intervals[i][1];
            Integer j = map.ceilingKey(right);
            if(j == null) {
                res[i] = -1;
            }else {
                res[i] = map.get(j);
            }
        }
        return res;
    }
}
