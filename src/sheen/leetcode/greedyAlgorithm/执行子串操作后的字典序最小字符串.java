package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 执行子串操作后的字典序最小字符串
 * @Date 2024/6/27 00:38
 * @Created by sheen
 * @Description TODO
 */
public class 执行子串操作后的字典序最小字符串 {
    public String smallestString(String s) {
        char[] cs = s.toCharArray();
        int left = 0;
        while (left < s.length() && s.charAt(left) == 'a') {
            left++;
        }

        boolean flag = false;
        while (left < s.length() && s.charAt(left) != 'a') {
            cs[left] = (char)(cs[left] - 1);
            left++;
            flag = true;
        }

        if (!flag) {
            cs[cs.length - 1] = 'z';
        }

        return String.valueOf(cs);
    }
}
