package com.company.array;

import com.company.util.ArrayUtils;

import java.util.*;

public class 不同整数的最少数目 {

    public static void main(String[] args) {
        不同整数的最少数目 s = new 不同整数的最少数目();
        System.out.println(s.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(k==arr.length) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }else {
                map.put(arr[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int len = arr.length;
        for(int i=list.size()-1;i>=0;i--) {
            len-=list.get(i);
            if(len<=k) return list.size()-i;
        }
        return 0;
    }

}
