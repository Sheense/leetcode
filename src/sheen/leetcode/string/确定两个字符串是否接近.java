package sheen.leetcode.string;

import java.util.*;

public class 确定两个字符串是否接近 {
    public static void main(String[] args) {
        确定两个字符串是否接近 s = new 确定两个字符串是否接近();
        System.out.println(s.closeStrings("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<word1.length();i++) map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);
        for(int i=0;i<word2.length();i++) map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
        List<Character> list = new ArrayList<>(map1.keySet());
        for(char key:list) {
            if(map1.get(key).equals(map2.getOrDefault(key, 0))) {
                map1.remove(key);
                map2.remove(key);
            }
        }
        if(map1.isEmpty()&&map2.isEmpty()) return true;
        if(map1.size()!= map2.size()) return false;
        for(char key:map1.keySet()){
            if(!map2.containsKey(key))return false;
        }
        while(!check(map1, map2)) {
            boolean flag = false;
            for(char key1 : map1.keySet()){
                for(char key2: map1.keySet()) {
                    if(key1!=key2&&map2.get(key1).equals(map1.get(key2))) {
                        int value = map1.get(key1);
                        map1.put(key1, map1.get(key2));
                        map1.put(key2, value);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag) return false;
        }
        return map1.isEmpty()&&map2.isEmpty();
    }

    public boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        List<Character> l = new ArrayList<>(map1.keySet());
        boolean flag = true;
        for(char key: l) {
            if(!map2.get(key).equals(map1.get(key))) {
                flag = false;
            }else {
                map1.remove(key);
                map2.remove(key);
            }
        }
        return flag;
    }
}
