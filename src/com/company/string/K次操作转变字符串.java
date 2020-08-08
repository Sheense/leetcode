package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class K次操作转变字符串 {
    public static void main(String[] args) {
        K次操作转变字符串 s = new K次操作转变字符串();
        System.out.println(s.canConvertString("aab","bbb", 27));
    }
    public boolean canConvertString(String s, String t, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            if(i==s.length()) {
                return false;
            }
            if(s.charAt(i)<t.charAt(i)) {
                int key = t.charAt(i)-s.charAt(i);
                map.put(key, map.getOrDefault(key, 0)+1);
            }else if(s.charAt(i)>t.charAt(i)) {
                int key = 26-Math.abs(t.charAt(i)-s.charAt(i));
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }
        while(map.size()!=0) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for(int i: map.keySet()) {
                if(i>k) return false;
                int item = map.get(i);
                if(item > 1) {
                    if(i+26>k) {
                        return false;
                    }
                    newMap.put(i+26, item-1);
                }
            }
            map = newMap;
        }
        return true;
    }
}
