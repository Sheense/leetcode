package com.company.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 形成两个异或相等数组的三元组数目 {
    public static void main(String[] args) {
        形成两个异或相等数组的三元组数目 s = new 形成两个异或相等数组的三元组数目();
        System.out.println(s.countTriplets(new int[]{2,3,1,6,7}));
    }
    public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] all = new int[arr.length];
        all[0] = arr[0];
        int res = 0;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0 , list);
        for (int i = 0; i<arr.length; i++) {
            if(i == 0) {
                all[i] = arr[0];
            }else {
                all[i] = all[i-1] ^ arr[i];
            }
            if (map.containsKey(all[i])) {
                for(int start : map.get(all[i])){
                    int value = start == -1 ? 0 : all[start];
                    for (int j = start + 1; j<i;j++) {
                        if ((all[j] ^ value) == (all[i] ^ all[j])) {
                            res++;
                        }
                    }
                }
                map.get(all[i]).add(i);
            }else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(all[i], l);
            }
        }
        return res;
    }
}
