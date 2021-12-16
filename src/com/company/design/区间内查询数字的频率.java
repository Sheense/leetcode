package com.company.design;

import java.util.*;

/**
 * @Classname 区间内查询数字的频率
 * @Date 2021/11/21 11:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 区间内查询数字的频率 {
    public static void main(String[] args) {
        RangeFreqQuery s = new RangeFreqQuery(new int[]{12,33,4,56,22,2,34,33,22,12,34,56});
        System.out.println(s.query(1,2,4));
        System.out.println(s.query(0, 11, 33));
    }
    static class RangeFreqQuery {

        private int id = 0;

        private Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        public RangeFreqQuery(int[] arr) {
            for(int i = 0; i < arr.length; i++) {
                TreeMap<Integer, Integer> m = map.computeIfAbsent(arr[i], x -> new TreeMap<>());
                m.put(i, m.size() + 1);
            }
        }

        public int query(int left, int right, int value) {
            if(!map.containsKey(value)) {
                return 0;
            }

            Integer l = map.get(value).ceilingKey(left);
            if(l == null || l > right) {
                return 0;
            }
            int lv = map.get(value).get(l);
            Integer r = map.get(value).floorKey(right);
            if(r == null || r < left) {
                return 0;
            }
            int rv = map.get(value).get(r);
            return rv - lv + 1;
        }
    }
}
