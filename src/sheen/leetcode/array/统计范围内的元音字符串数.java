package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 统计范围内的元音字符串数
 * @Date 2023/5/8 4:22 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计范围内的元音字符串数 {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));
        for(int i = left; i <= right; i++) {
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                res ++;
            }
        }
        return res;
    }
}
