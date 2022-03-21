package com.company.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 相同元素的间隔之和
 * @Date 2021/12/26 11:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 相同元素的间隔之和 {

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        long[] res = new long[arr.length];
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            int end = list.get(list.size() - 1);
            long count = 0;
            for(int i = list.size() - 2; i >= 0; i--){
                count += end - list.get(i);
            }

            for(int i = list.size() - 1; i >= 0; i--) {
                if(i != list.size() - 1) {
                    int n = list.get(i + 1) - list.get(i);
                    count -= i * n;
                    count += (list.size() - 1 - i - 1) * n;
                }
                res[list.get(i)] = count;
            }
        }
        return res;
    }
}
