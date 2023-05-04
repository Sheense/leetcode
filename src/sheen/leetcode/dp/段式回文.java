package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 段式回文
 * @Date 2023/4/12 10:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 段式回文 {
    public static void main(String[] args) {
        段式回文 s = new 段式回文();
        System.out.println(s.longestDecomposition("elvtoelvto"));
    }
    public int longestDecomposition(String text) {
        return dp(0, text.length() - 1, text, new HashMap<>());
    }

    public int dp(int s, int e, String text, Map<String, Integer> map) {
        if(s > e) {
            return 0;
        }
        if(s == e) {
            return 1;
        }
        String key = s + "_" + e;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int max = 1;
        int len = e - s + 1;
        for(int i = 1; i <= len / 2; i++) {
            String left = text.substring(s, s + i);
            String right = text.substring(e - i + 1, e + 1);
            if(left.equals(right)) {
                int next = dp(s + i, e - i, text, map);
                max = Math.max(next + 2, max);
            }
        }
        map.put(key, max);
        return max;
    }
}
