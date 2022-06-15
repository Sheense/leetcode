package com.company.map;

import java.util.*;

/**
 * @Classname 外星文字典
 * @Date 2022/5/31 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 外星文字典 {
    public static void main(String[] args) {
        外星文字典 s = new 外星文字典();
        System.out.println(s.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> du = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                map.computeIfAbsent(words[i].charAt(j), x -> new ArrayList<>());
            }
        }

        for(int i = 1; i < words.length; i++) {
            boolean flag = addEdge(words[i-1], words[i], map, du);
            if(!flag) {
                return "";
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char c : map.keySet()) {
            if(!du.containsKey(c)) {
                queue.offer(c);
            }
        }


        String res = "";
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                char c = queue.poll();
                du.remove(c);
                res += c;
                if(map.containsKey(c)) {
                    List<Character> nexts = map.get(c);
                    for(char next : nexts) {
                        du.put(next, du.get(next) - 1);
                        if(du.get(next) == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        if(!du.isEmpty()) {
            return "";
        }

        return res;
    }

    public boolean addEdge(String w1, String w2, Map<Character, List<Character>> map, Map<Character, Integer> du) {
        int length = Math.min(w1.length(), w2.length());
        int index = 0;
        while (index < length) {
            char c1 = w1.charAt(index);
            char c2 = w2.charAt(index);
            if(c1 != c2) {
                map.get(c1).add(c2);
                du.put(c2, du.getOrDefault(c2, 0) + 1);
                break;
            }
            index++;
        }

        if(index == length && w1.length() > w2.length()) {
            return false;
        }

        return true;
    }
}
