package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 统计范围内的元音字符串数2
 * @Date 2023/6/2 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计范围内的元音字符串数2 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));
        int[] arr = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                arr[i] = 1;
            }
            if(i > 0) {
                arr[i] += arr[i - 1];
            }
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            if(queries[i][0] == 0) {
                res[i] = arr[queries[i][1]];
            }else {
                res[i] =  arr[queries[i][1]] - arr[queries[i][0] - 1];
            }
        }
        return res;
    }
}
