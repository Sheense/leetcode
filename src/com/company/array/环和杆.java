package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * @Classname 环和杆
 * @Date 2021/12/12 10:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 环和杆 {
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int v = rings.charAt(i + 1) - '0';
            map.computeIfAbsent(v, x -> new HashSet<>()).add(c);
        }

        int res = 0;
        for(int key : map.keySet()) {
            Set<Character> set = map.get(key);
            if(set.contains('R') && set.contains('G') && set.contains('B')) {
                res++;
            }
        }
        return res;
    }
}
