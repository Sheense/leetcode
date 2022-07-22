package sheen.leetcode.string;

public class 反转字符串 {
    public void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++) {
            s[i] = (char)(s[i] + s[s.length-1-i]);
            s[s.length-1-i] = (char)(s[i] - s[s.length-1-i]);
            s[i] = (char)(s[i] - s[s.length-1-i]);
        }
    }
}
