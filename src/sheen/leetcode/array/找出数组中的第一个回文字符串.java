package sheen.leetcode.array;

/**
 * @Classname 找出数组中的第一个回文字符串
 * @Date 2021/12/19 10:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组中的第一个回文字符串 {
    public String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++) {
            boolean flag = true;
            for(int j = 0; j < words[i].length()/2; j++) {
                if(words[i].charAt(j) != words[i].charAt(words[i].length() - 1 - j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return words[i];
            }
        }
        return "";
    }
}
