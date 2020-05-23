package com.company.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最小覆盖子串 {

    public static void main(String[] args) {
        最小覆盖子串 s = new 最小覆盖子串();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            if(map1.containsKey(t.charAt(i))) {
                map1.put(t.charAt(i), map1.get(t.charAt(i))+1);
            }else {
                map1.put(t.charAt(i), 1);
            }
            map2.put(t.charAt(i), 0);
        }
        int start = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))) {
                map2.put(s.charAt(i), map2.get(s.charAt(i))+1);
            }
            while(check(map1,map2)&&start<=i) {
                if(min>i-start+1) {
                    min = i-start+1;
                    res = s.substring(start,i+1);
                }
                if(map2.containsKey(s.charAt(start))) {
                    map2.put(s.charAt(start), map2.get(s.charAt(start))-1);
                }
                start++;
            }
        }
        return res;
    }

    public boolean check(Map<Character,Integer> map1,Map<Character,Integer>map2) {
        for(char c:map1.keySet()) {
            if(map2.get(c)<map1.get(c)) {
                return false;
            }
        }
        return true;
    }

}
