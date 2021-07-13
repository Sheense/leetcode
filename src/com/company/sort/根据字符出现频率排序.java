package com.company.sort;

import java.util.*;

public class 根据字符出现频率排序 {
    public static void main(String[] args) {
        根据字符出现频率排序 s = new 根据字符出现频率排序();
        System.out.println(s.frequencySort("tree"));
    }
    public String frequencySort(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            set.add(s.charAt(i));
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> characters = new ArrayList<>(set);
        Collections.sort(characters, (o1, o2) -> map.get(o1) - map.get(o2));
        String res = "";

        for(int i = characters.size() - 1; i >= 0; i--) {
            char c = characters.get(i);
            for(int j = 0; j < map.get(c); j++) {
                res += c;
            }
        }
        return res;
    }
}
