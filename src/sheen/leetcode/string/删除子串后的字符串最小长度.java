package sheen.leetcode.string;

/**
 * @Classname 删除子串后的字符串最小长度
 * @Date 2024/1/10 00:51
 * @Created by sheen
 * @Description TODO
 */
public class 删除子串后的字符串最小长度 {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if(s.contains("AB")) {
                s = change(s, "AB");
            }
            if(s.contains("CD")) {
                s = change(s, "CD");
            }
        }
        return s.length();
    }

    public String change(String s, String sub) {
        int index = s.indexOf(sub);
        if(index + 2 == s.length()) {
            return s.substring(0, index);
        }

        return s.substring(0, index) + s.substring(index + 2);
    }
}
