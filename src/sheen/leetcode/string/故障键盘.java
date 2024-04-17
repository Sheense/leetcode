package sheen.leetcode.string;

/**
 * @Classname 故障键盘
 * @Date 2024/4/1 00:28
 * @Created by sheen
 * @Description TODO
 */
public class 故障键盘 {
    public String finalString(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'i') {
                res.reverse();
            }else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
