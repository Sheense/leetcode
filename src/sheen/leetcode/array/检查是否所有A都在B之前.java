package sheen.leetcode.array;

/**
 * @Classname 检查是否所有A都在B之前
 * @Date 2022/1/2 10:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检查是否所有A都在B之前 {
    public boolean checkString(String s) {
        char c = s.charAt(0);
        for(int i = 0 ; i < s.length(); i++) {
            if(c == 'a'&& s.charAt(i) == 'b') {
                c = 'b';
            }
            if(c == 'b' && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}
