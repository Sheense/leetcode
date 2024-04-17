package sheen.leetcode.string;

/**
 * @Classname 最长平衡子字符串
 * @Date 2023/11/8 00:54
 * @Created by sheen
 * @Description TODO
 */
public class 最长平衡子字符串 {
    public int findTheLongestBalancedSubstring(String s) {
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0')  {
                int left = i;
               while (left < s.length() && s.charAt(left) == '0') {
                   left++;
               }
               int right = left;
               while (right < s.length() && s.charAt(right) == '1') {
                   right++;
               }
               res = Math.max(res, Math.max(right - left, left - i));
               i = right;
            }else {
                i++;
            }
        }

        return res;
    }
}
