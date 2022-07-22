package sheen.leetcode.string;

/**
 * @Classname 反转字符串II
 * @Date 2021/8/20 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转字符串II {
    public String reverseStr(String s, int k) {
        int i = 0;
        String res = "";
        while (i < s.length()) {
            int end = i + 2 * k;
            if(end <= s.length()) {
                StringBuffer sb = new StringBuffer(s.substring(i, i + k));
                res += sb.reverse();
                res += s.substring(i+k, end);
                i = end;
            }else {
                StringBuffer sb = new StringBuffer(s.substring(i, Math.min(i + k, s.length())));
                res += sb.reverse();
                if(s.length() > i + k) {
                    res += s.substring(i+k);
                }
                i = s.length();
            }
        }
        return res;
    }
}
