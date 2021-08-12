package com.company.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 变位词组
 * @Date 2021/7/18 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 变位词组 {
    public static void main(String[] args) {
        变位词组 s = new 变位词组();
        System.out.println(s.groupAnagrams(new String[]{"huh","tit"}));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] arr = new int[26];
            for(int j = 0; j<strs[i].length(); j++) {
                arr[strs[i].charAt(j) - 'a']++;
            }
            String item = "";
            for(int j = 0; j < arr.length;j++) {
                if(arr[j] != 0) {
                    char a = (char)(j+'a');
                    item += a + String.valueOf(arr[j]) + "#";
                }
            }
            map.computeIfAbsent(item, x -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
