package sheen.leetcode.sort;

/**
 * @Classname 制造字母异位词的最小步骤数
 * @Date 2023/5/9 11:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 制造字母异位词的最小步骤数 {
    public int minSteps(String s, String t) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s.length(); i++) {
            c1[s.charAt(i) - 'a']++;
            c2[t.charAt(i) - 'a']++;
        }

        int a = 0;
        for(int i = 0; i < 26; i++) {
            if(c1[i] > c2[i]) {
                a += c1[i] - c2[i];
            }
        }
        return a ;
    }
}
