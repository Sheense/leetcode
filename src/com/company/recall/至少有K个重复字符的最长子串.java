package com.company.recall;

import java.util.ArrayList;
import java.util.List;

public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        int[] map = new int[26];
        for(int i=0;i<s.length();i++) {
            map[s.charAt(i)-'a']++;
        }
        List<Integer> split = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            if(map[s.charAt(i)-'a']<k) {
                split.add(i);
            }
        }
        if(split.size()==0) return s.length();
        split.add(s.length());
        int left = 0;
        int max = 0;
        for(int right:split) {
            max = Math.max(longestSubstring(s.substring(left, right),k), max);
            left = right+1;
            if(left==s.length()) break;
        }
        return max;
    }
}
