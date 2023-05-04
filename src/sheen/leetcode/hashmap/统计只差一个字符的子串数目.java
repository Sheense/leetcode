package sheen.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 统计只差一个字符的子串数目
 * @Date 2023/3/27 12:28 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计只差一个字符的子串数目 {
    public static void main(String[] args) {
        统计只差一个字符的子串数目 s = new 统计只差一个字符的子串数目();
        System.out.println(s.countSubstrings("aba", "baba"));
    }
    public int countSubstrings(String s, String t) {
        int res = 0;
        Map<String, Integer> map1 = getMap(s);
        Map<String, Integer> map2 = getMap(t);
        for(String key : map1.keySet()) {
            for(int i = 0; i < key.length(); i++) {
                for(int j = 0; j < 26; j++) {
                    if(key.charAt(i) == 'a' + j) {
                        continue;
                    }
                    String newKey;
                    if(key.length() == 1) {
                        newKey = String.valueOf((char)(j + 'a'));
                    }else {
                        if(i == 0) {
                            newKey = (char)('a' + j) + key.substring(1);
                        }else if(i == key.length() - 1) {
                            newKey = key.substring(0, key.length() - 1) + (char)('a' + j);
                        }else {
                            newKey = key.substring(0, i) + (char)('a' + j) + key.substring(i + 1);
                        }
                    }

                    res += map1.get(key) * map2.getOrDefault(newKey, 0);
                }
            }
        }
        return res;

    }

    public Map<String, Integer> getMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j <= s.length() - i; j++) {
                String key = s.substring(j, j + i);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }
}
