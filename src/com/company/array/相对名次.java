package com.company.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 相对名次
 * @Date 2021/12/2 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 相对名次 {
    public String[] findRelativeRanks(int[] score) {
        int[] copy = new int[score.length];
        for(int i = 0; i < score.length; i++) copy[i] = score[i];
        Arrays.sort(copy);
        Map<Integer, String> map = new HashMap<>();
        int index = 4;
        for(int i = score.length - 1; i >= 0; i--) {
            if(i == score.length - 1) {
                map.put(copy[i], "Gold Medal");
            }else if(i == score.length - 2) {
                map.put(copy[i], "Silver Medal");
            }else if(i == score.length - 3) {
                map.put(copy[i], "Bronze Medal");
            }else {
                map.put(copy[i], String.valueOf(index++));
            }
        }
        String[] res = new String[score.length];
        for(int i = 0; i < score.length; i++) {
            res[i] = map.get(score[i]);
        }
        return res;
    }
}
