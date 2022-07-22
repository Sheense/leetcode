package sheen.leetcode.array;

/**
 * @Classname 连续字符
 * @Date 2021/12/1 12:44 上午
 * @Created by sheen
 * @Description TODO
 */
public class 连续字符 {
    public int maxPower(String s) {
        int max = 1;
        int index = 0;
        while (index < s.length()) {
            int i = index;
            while (i < s.length() && s.charAt(i) == s.charAt(index)) {
                i++;
            }
            max = Math.max(max, i - index);
            index = i;
        }
        return max;
    }
}
