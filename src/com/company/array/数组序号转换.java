package com.company.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组序号转换 {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            res[i] = arr[i];
        }
        Arrays.sort(arr);
        int index = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], index);
                index++;
            }
        }
        for(int i=0;i<res.length;i++) {
            res[i] = map.get(res[i]);
        }
        return res;
    }
}
