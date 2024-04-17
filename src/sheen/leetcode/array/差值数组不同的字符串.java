package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 差值数组不同的字符串
 * @Date 2023/5/25 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 差值数组不同的字符串 {
    public static void main(String[] args) {
        差值数组不同的字符串 s = new 差值数组不同的字符串();
        System.out.println(s.oddString(new String[]{"adc","wzy","abc"}));
    }
    public String oddString(String[] words) {
        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String item = "";
            for(int j = 0; j < words[i].length() - 1; j++) {
                item += words[i].charAt(j + 1) - words[i].charAt(j) + "#";
            }
            final int v = i;
            map.computeIfAbsent(item, x -> new int[]{v, 0})[1]++;
        }

        for(int[] v : map.values()) {
            if(v[1] == 1) {
                return words[v[0]];
            }
        }
        return "";
    }
}
