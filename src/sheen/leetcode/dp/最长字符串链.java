package sheen.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 最长字符串链
 * @Date 2023/4/27 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长字符串链 {
    public static void main(String[] args) {
        最长字符串链 s = new 最长字符串链();

    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (i, j) -> i.length() - j.length());
        Map<String, Integer> map = new HashMap<>();
        int max = 1;
        for(int i = 0; i < words.length; i++) {
            int v = 0;
            if(words[i].length() > 1) {
                for(int j = 0; j < words[i].length(); j++) {
                    String newStr = "";
                    if(j == 0) {
                        newStr = words[i].substring(1);
                    }else if(j == words[i].length() - 1) {
                        newStr = words[i].substring(0, words[i].length() - 1);
                    }else {
                        newStr = words[i].substring(0, j) + words[i].substring(j + 1);
                    }
                    if(map.containsKey(newStr)) {
                        v = Math.max(v, map.get(newStr));
                    }
                }
            }
            map.put(words[i], v + 1);
            max = Math.max(max, v + 1);
        }

        return max;
    }
}
