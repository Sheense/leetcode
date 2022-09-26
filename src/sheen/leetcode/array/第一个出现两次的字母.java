package sheen.leetcode.array;

/**
 * @Classname 第一个出现两次的字母
 * @Date 2022/7/24 10:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 第一个出现两次的字母 {
    public char repeatedCharacter(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if(arr[s.charAt(i) - 'a'] >= 2) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
