package sheen.leetcode.string;

/**
 * @Classname 字典序最小回文串
 * @Date 2023/12/13 00:19
 * @Created by sheen
 * @Description TODO
 */
public class 字典序最小回文串 {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++) {
            if(cs[i] != cs[s.length() - 1 - i]) {
                char v = (char)Math.min(cs[i], cs[s.length() - 1 - i]);
                cs[i] = v;
                cs[s.length() - 1 - i] = v;
            }
        }
        return String.valueOf(cs);
    }
}
