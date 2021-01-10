package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:arr) {
            map.put(a, map.getOrDefault(a,0)+1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
