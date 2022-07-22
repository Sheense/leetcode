package sheen.leetcode.string;

/**
 * @Classname 反转两次的数字
 * @Date 2021/12/26 11:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 反转两次的数字 {
    public boolean isSameAfterReversals(int num) {
        if(num < 10) return true;
        String str = String.valueOf(num);
        return str.charAt(str.length() - 1) != '0';
    }
}
