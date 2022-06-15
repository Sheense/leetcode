package com.company.array;

import java.util.*;

/**
 * @Classname 查找和替换模式
 * @Date 2022/6/12 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 查找和替换模式 {
    public static void main(String[] args) {
        查找和替换模式 s = new 查找和替换模式();
        System.out.println(s.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},
        "abb"));
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            Map<Character, Character> pToW = new HashMap<>();
            Map<Character, Character> wTop = new HashMap<>();
            if(words[i].length() != pattern.length()) {
                continue;
            }
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++) {
                if(pToW.containsKey(pattern.charAt(j)) && pToW.get(pattern.charAt(j)) != words[i].charAt(j)) {
                    flag = false;
                    break;
                }
                if(wTop.containsKey(words[i].charAt(j)) && wTop.get(words[i].charAt(j)) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
                pToW.put(pattern.charAt(j), words[i].charAt(j));
                wTop.put(words[i].charAt(j), pattern.charAt(j));
            }
            if(flag) {
                res.add(words[i]);
            }
        }

        return res;
    }
}
