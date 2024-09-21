package sheen.leetcode.math;

/**
 * @Classname 哈沙德数
 * @Date 2024/7/3 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 哈沙德数 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int and = 0;
        int y = x;
        while (y != 0) {
            and += y % 10;
            y /= 10;
        }

        if(x % and == 0) {
            return and;
        }

        return -1;
    }
}
