package com.company.map;

import com.company.util.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 网格照明
 * @Date 2022/2/8 12:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 网格照明 {
    public static void main(String[] args) {
        网格照明 s = new 网格照明();
        ArrayUtils.print(s.gridIllumination(5, new int[][]{{0,0},{4,4}}, new int[][]{{1,1},{1,0}}));
    }
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for(int i = 0; i < lamps.length; i++) {
            if(!set.add(hash(lamps[i][0], lamps[i][1]))) continue;;
            row.put(lamps[i][0], row.getOrDefault(lamps[i][0], 0) + 1);
            col.put(lamps[i][1], col.getOrDefault(lamps[i][1], 0) + 1);
            m1.put(lamps[i][0] - lamps[i][1], m1.getOrDefault(lamps[i][0] - lamps[i][1], 0) + 1);
            m2.put(lamps[i][0] + lamps[i][1], m2.getOrDefault(lamps[i][0] + lamps[i][1], 0) + 1);
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            if(row.getOrDefault(r, 0) > 0|| col.getOrDefault(c, 0) > 0 || m1.getOrDefault(r - c, 0) > 0 || m2.getOrDefault(r + c, 0) > 0) {
                res[i] = 1;
            }
            for(int x = r - 1; x <= r + 1; x++) {
                for(int y = c - 1; y <= c + 1; y++) {
                    if(x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if(set.remove(hash(x, y))) {
                        row.put(x, row.get(x) - 1);
                        if(row.get(x) == 0) {
                            row.remove(x);
                        }
                        col.put(y, col.get(y) - 1);
                        if(col.get(y) == 0) {
                            col.remove(y);
                        }
                        m1.put(x - y, m1.get(x - y) - 1);
                        if(m1.get(x - y) == 0) {
                            m1.remove(x - y);
                        }
                        m2.put(x + y, m2.get(x + y) - 1);
                        if(m2.get(x + y) == 0) {
                            m2.remove(x + y);
                        }
                    }
                }
            }
        }
        return res;
    }

    public long hash(long a, long b) {
        return (a << 32) + b;
    }


}
