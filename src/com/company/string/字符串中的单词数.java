package com.company.string;

import com.company.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 字符串中的单词数
 * @Date 2021/10/7 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字符串中的单词数 {
    public static void main(String[] args) {
        字符串中的单词数 s = new 字符串中的单词数();
        System.out.println(s.countSegments("ss  aa "));
    }
    public int countSegments(String s) {
        String[] arr = s.split(" ");
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i].trim().equals("")) {
                count++;
            }
        }
        return count;
    }
}
