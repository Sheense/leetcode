package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 能否连接形成数组 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<pieces.length;i++) {
            map.put(pieces[i][0], i);
        }
        int index = 0;
        while(index<arr.length) {
            if(!map.containsKey(arr[index])) return false;
            int i = map.get(arr[index]);
            int j = 0;
            while(j!=pieces[i].length&&pieces[i][j] == arr[index]) {
                j ++;
                index++;
                if(j!=pieces[i].length&&pieces[i][j]!=arr[index]) {
                    return false;
                }
            }
        }
        return true;
    }
}
