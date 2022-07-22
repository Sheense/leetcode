package sheen.leetcode.hash;

import java.util.Arrays;

public class 有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(new String(c1).equals(new String(c2))) {
            return true;
        }
        return false;
    }
}
