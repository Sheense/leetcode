package com.company.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 词典中最长的单词
 * @Date 2022/3/17 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 词典中最长的单词 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
        }

        int max = 0;
        String res = "";
        for(int i = 0; i < words.length; i++) {
            int j = words[i].length() - 1;
            boolean flag = true;
            while (j > 0) {
                String str = words[i].substring(0, j);
                if(!set.contains(str)) {
                    flag = false;
                    break;
                }
                j--;
            }
            if(flag) {
                if(words[i].length() > max) {
                    max = words[i].length();
                    res = words[i];
                }else if(words[i].length() == max) {
                    if(words[i].compareTo(res) < 0) {
                        res = words[i];
                    }
                }
            }
        }
        return res;
    }
}
