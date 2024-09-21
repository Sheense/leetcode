package sheen.leetcode.GeminiNeedle;

/**
 * @Classname 最长的字母序连续子字符串的长度
 * @Date 2024/9/19 00:04
 * @Created by sheen
 * @Description TODO
 */
public class 最长的字母序连续子字符串的长度 {
    public int longestContinuousSubstring(String s) {
        int left = 0;
        int ans = 1;
        while (left < s.length()) {
            int index = left;
            while (index + 1 < s.length() && s.charAt(index) + 1 == s.charAt(index + 1)) {
                index++;
            }
            ans = Math.max(ans, index - left + 1);
            left = index + 1;
        }
        return ans;
    }

}
