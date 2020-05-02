package com.company.window;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        无重复字符的最长子串 s = new 无重复字符的最长子串();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int last = 0;
        for(int i=0;i<s.length();i++) {
            int start = i;
            int end = last;
            int index = last+1;
            while(index<s.length()) {
                if(s.substring(start, end+1).contains(s.substring(index, index+1))){
                    break;
                }else {
                    end++;
                    index++;
                }
            }
            if(end-start+1>max) max = end-start+1;
            last = end;
        }
        return max;
    }
}
