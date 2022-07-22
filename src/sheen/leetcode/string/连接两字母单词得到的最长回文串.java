package sheen.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 连接两字母单词得到的最长回文串
 * @Date 2022/1/8 10:57 下午
 * @Created by sheen
 * @Description TODO
 */
public class 连接两字母单词得到的最长回文串 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int len = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].charAt(0) == words[i].charAt(1)) {
                map2.put(words[i], map2.getOrDefault(words[i], 0) + 1);
            }else {
                String newString = String.valueOf(words[i].charAt(1)) + words[i].charAt(0);
                int count = map1.getOrDefault(newString, 0);
                if(count != 0) {
                    len += 4;
                    map1.put(newString, count - 1);
                }else {
                    map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
                }
            }
        }
        boolean flag = false;
        for(String key : map2.keySet()) {
            if(map2.get(key) % 2 == 0) {
                len += map2.get(key) * 2;
            }else {
                if(flag) {
                    len += (map2.get(key) - 1) * 2;
                }else {
                    len += map2.get(key) * 2;
                    flag = true;
                }
            }
        }
        return len;
    }
}
