package com.company.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 优美的排列
 * @Date 2021/8/16 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 优美的排列 {
    public int countArrangement(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j % i == 0 && i % j == 0) {
                    map.computeIfAbsent(i, x -> new ArrayList<>()).add(j);
                }
            }
        }
        boolean[] check = new boolean[n+1];
        return recall(1, check, map);
    }

    public int recall(int i, boolean[] check, Map<Integer, List<Integer>> map) {
        if(i == check.length) {
            return 1;
        }
        int res = 0;
        List<Integer> list = map.get(i);
        for(int item : list) {
            if(!check[item]) {
                check[item] = true;
                res += recall(i+1, check, map);
                check[item] = false;
            }
        }
        return res;
    }
}
