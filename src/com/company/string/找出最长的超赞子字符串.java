package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class 找出最长的超赞子字符串 {

    public static void main(String[] args) {
        找出最长的超赞子字符串 s = new 找出最长的超赞子字符串();
        System.out.println(s.longestAwesome("9498331"));
    }
    public int longestAwesome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> nums = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int res = 0;
        return res;
    }
}
