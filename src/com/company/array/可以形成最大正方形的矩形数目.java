package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 可以形成最大正方形的矩形数目 {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<rectangles.length;i++) {
            int max = Math.min(rectangles[i][0], rectangles[i][1]);
            map.put(max, map.getOrDefault(max, 0) + 1);
            res = Math.max(res, max);
        }
        return map.get(res);
    }
}
