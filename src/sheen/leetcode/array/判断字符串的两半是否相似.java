package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 判断字符串的两半是否相似 {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length()/2;i++){
            if(set.contains(s.charAt(i))) left++;
            if(set.contains(s.charAt(s.length()-1-i))) right++;
        }
        return left==right;
    }
}
