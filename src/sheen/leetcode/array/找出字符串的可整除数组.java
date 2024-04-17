package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 找出字符串的可整除数组
 * @Date 2024/3/7 01:03
 * @Created by sheen
 * @Description TODO
 */
public class 找出字符串的可整除数组 {
    public static void main(String[] args) {
        找出字符串的可整除数组 s= new 找出字符串的可整除数组();
        ArrayUtils.print(s.divisibilityArray("998244353", 33));
    }
    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        long[] yus = new long[word.length()];
        for(int i = 0; i < word.length(); i++) {
            long num = (word.charAt(i) - '0');
            if(i > 0) {
                num += yus[i - 1] * 10;
            }
            long yu = num % m;
            if(yu == 0) {
                res[i] = 1;
            }
            yus[i] = yu;
        }
        return res;
    }
}
