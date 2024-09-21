package sheen.leetcode.array;

/**
 * @Classname 两个字符串的排列差
 * @Date 2024/8/24 00:17
 * @Created by sheen
 * @Description TODO
 */
public class 两个字符串的排列差 {
    public int findPermutationDifference(String s, String t) {
        int[] arr = new int[26];
        for(int i = 0; i < t.length(); i++) {
            arr [t.charAt(i) - 'a'] = i;
        }

        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res += Math.abs(i - arr[s.charAt(i) - 'a']);
        }

        return res;
    }
}
