package sheen.leetcode.window;

public class 长度为三且各字符不同的子字符串 {
    public int countGoodSubstrings(String s) {
        int res = 0;
        for(int i = 1; i < s.length() -1;i++ ) {
            if(s.charAt(i-1) != s.charAt(i) && s.charAt(i-1) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+1)) {
                res++;
            }
        }
        return res;
    }
}
