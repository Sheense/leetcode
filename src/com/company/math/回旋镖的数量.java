package com.company.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 回旋镖的数量
 * @Date 2021/9/13 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i ++) {
            Map<Integer, Integer> count = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                int l = (int)Math.pow(points[j][1] - points[i][1], 2) + (int)Math.pow(points[j][0] - points[i][0], 2);
                count.put(l, count.getOrDefault(l, 0) + 1);
            }
            for(int value : count.values()) {
                res += value * (value-1);
            }
        }
        return res;
    }
    public boolean check(int a, int b, int c, Map<Integer, Map<Integer, Long>> map) {
        long l1 = map.get(a).get(b);
        long l2 = map.get(a).get(c);
        return l1 == l2;
    }
}
