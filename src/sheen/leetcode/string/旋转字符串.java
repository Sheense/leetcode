package sheen.leetcode.string;

/**
 * @Classname 旋转字符串
 * @Date 2022/4/7 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 旋转字符串 {
    public boolean rotateString(String s, String goal) {
        for(int i = 1; i < s.length(); i++) {
            String v = s.substring(i) + s.substring(0, i);
            if(goal.equals(v)) {
                return true;
            }
        }
        return false;
    }
}
