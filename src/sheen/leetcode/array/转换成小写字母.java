package sheen.leetcode.array;

/**
 * @Classname 转换成小写字母
 * @Date 2021/12/12 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 转换成小写字母 {
    public String toLowerCase(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res += (char)(s.charAt(i) - 'A' + 'a');
            }else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
