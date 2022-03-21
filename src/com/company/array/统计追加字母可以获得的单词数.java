package com.company.array;

import java.util.*;

/**
 * @Classname 统计追加字母可以获得的单词数
 * @Date 2022/1/9 11:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计追加字母可以获得的单词数 {
    public static void main(String[] args) {
        统计追加字母可以获得的单词数 s = new 统计追加字母可以获得的单词数();
        System.out.println(s.wordCount(new String[]{"ab","a"}, new String[]{"abc","abcd"}));
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < startWords.length; i++) {
            int mask = 0;
            for(int j = 0; j < startWords[i].length(); j++) {
                mask += (1 << (startWords[i].charAt(j) - 'a'));
            }
            set.add(mask);
        }
        int res = 0;
        for(int i = 0; i < targetWords.length; i++) {
            int mask = 0;
            for(int j = 0; j < targetWords[i].length(); j++) {
                mask += (1 << (targetWords[i].charAt(j) - 'a'));
            }

            for(int j = 0; j < targetWords[i].length(); j++) {
                int newMask = mask - (1 << (targetWords[i].charAt(j) - 'a'));
                if(set.contains(newMask)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }





}
