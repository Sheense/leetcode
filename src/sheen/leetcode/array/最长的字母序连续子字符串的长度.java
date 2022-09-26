package sheen.leetcode.array;

/**
 * @Classname 最长的字母序连续子字符串的长度
 * @Date 2022/9/18 11:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长的字母序连续子字符串的长度 {
    public int longestContinuousSubstring(String s) {
        int i = 0;
        int res = 1;
        while (i < s.length()) {
            int start = i;
            i++;
            while (i < s.length() && s.charAt(i) - 1 == s.charAt(i - 1)) {
                i++;
            }

            res = Math.max(i - start, res);
        }
        return res;
    }
}
