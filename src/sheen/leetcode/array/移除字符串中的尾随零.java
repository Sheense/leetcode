package sheen.leetcode.array;

/**
 * @Classname 移除字符串中的尾随零
 * @Date 2024/6/29 01:12
 * @Created by sheen
 * @Description TODO
 */
public class 移除字符串中的尾随零 {
    public String removeTrailingZeros(String num) {
        for(int i = num.length() - 1; i >= 0; i--) {
            if(num.charAt(i) != '0') {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
