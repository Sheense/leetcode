package com.company.string;

import com.company.util.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class 字符串中不同整数的数目 {
    public static void main(String[] args) {
        字符串中不同整数的数目 s = new 字符串中不同整数的数目();
        System.out.println(s.numDifferentIntegers("a"));
    }
    public int numDifferentIntegers(String word) {
        int index = 0;
        Set<String> set = new HashSet<>();
        while (index<word.length()) {
            while (index<word.length()&&(word.charAt(index)<'0'||word.charAt(index)>'9')) index++;
            int start = index;
            while (index<word.length()&&word.charAt(index)>='0'&&word.charAt(index)<='9') {
                index++;
            }
            while (start<index-1&&word.charAt(start) == '0')start++;
            if(start<index) {

                set.add(word.substring(start, index));
            }
        }

        return set.size();
    }
}
