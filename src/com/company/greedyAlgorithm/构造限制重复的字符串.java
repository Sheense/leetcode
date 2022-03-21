package com.company.greedyAlgorithm;

import java.util.*;

/**
 * @Classname 构造限制重复的字符串
 * @Date 2022/2/20 11:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 构造限制重复的字符串 {
    public static void main(String[] args) {
        构造限制重复的字符串 s = new 构造限制重复的字符串();
        System.out.println(s.repeatLimitedString("aababab", 2));
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int maxIndex = arr.length - 1;
        while (maxIndex >= 0 && arr[maxIndex] == 0) {
            maxIndex --;
        }

        String res = "";
        int minIndex = maxIndex - 1;
        while (minIndex >= 0 && arr[minIndex] == 0) {
            minIndex --;
        }

        while (arr[maxIndex] > 0 && arr[minIndex] > 0) {
            res += 0;
        }




        return res;
    }
}
