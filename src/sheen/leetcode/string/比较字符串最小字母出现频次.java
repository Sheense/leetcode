package sheen.leetcode.string;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 比较字符串最小字母出现频次
 * @Date 2023/6/10 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 比较字符串最小字母出现频次 {
    public static void main(String[] args) {
        比较字符串最小字母出现频次 s = new 比较字符串最小字母出现频次();
        ArrayUtils.print(s.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}));
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            int[] c = new int[26];
            for(int j = 0; j < words[i].length(); j++) {
                c[words[i].charAt(j) - 'a']++;
            }
            for(int j = 0; j < c.length; j++) {
                if(c[j] != 0) {
                    count[i] = c[j];
                    break;
                }
            }
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int num = 0;
            int[] c = new int[26];
            for(int j = 0; j < queries[i].length(); j++) {
                c[queries[i].charAt(j) - 'a']++;
            }
            for(int j = 0; j < c.length; j++) {
                if(c[j] != 0) {
                    num = c[j];
                    break;
                }
            }
            for(int j = 0; j < count.length; j++) {
                if(count[j] > num) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
