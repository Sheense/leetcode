package com.company.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 两句话中的不常见单词
 * @Date 2022/1/30 12:36 下午
 * @Created by sheen
 * @Description TODO
 */
public class 两句话中的不常见单词 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        for(int i = 0; i < str1.length; i++) {
            map.put(str1[i], map.getOrDefault(str1[i], 0) + 1);
        }
        for(int i = 0; i < str2.length; i++) {
            map.put(str2[i], map.getOrDefault(str2[i], 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                res.add(key);
            }
        }
        String[] ans = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
