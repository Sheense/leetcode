package sheen.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 兼具大小写的最好英文字母
 * @Date 2022/6/19 11:42 上午
 * @Created by sheen
 * @Description TODO
 */
public class 兼具大小写的最好英文字母 {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if(set.contains((char)('A' + (s.charAt(i) - 'a')))) {
                    if(res.equals("")||(char)('A' + (s.charAt(i) - 'a')) > res.charAt(0)) {
                        res = "";
                        res += (char)('A' + (s.charAt(i) - 'a'));
                    }
                }
            }

            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if(set.contains((char)('a' + (s.charAt(i) - 'A')))) {
                    if(res.equals("") || res.charAt(0) < s.charAt(i)) {
                        res = "";
                        res += s.charAt(i);
                    }
                }
            }
            set.add(s.charAt(i));
        }

        return res;
    }
}
