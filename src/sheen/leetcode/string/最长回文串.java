package sheen.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class 最长回文串 {
    public static void main(String[] args) {
        最长回文串 s = new 最长回文串();
        System.out.println(s.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Short> map = new HashMap<>();
        short init = 0;
        for(int i=0;i<chars.length;i++) {
            if(!map.containsKey(chars[i])) {
                map.put(chars[i], init);
            }
            short value = map.get(chars[i]);
            map.put(chars[i], ++value);
        }
        int res = 0;
        int middle = 0;
        for(short count : map.values()) {
            if(count%2 == 1) middle = 1;
            res += count- count%2;
        }
        return res + middle;
    }



}
