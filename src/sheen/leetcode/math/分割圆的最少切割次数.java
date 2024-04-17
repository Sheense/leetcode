package sheen.leetcode.math;

/**
 * @Classname 分割圆的最少切割次数
 * @Date 2023/6/17 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分割圆的最少切割次数 {

    public int numberOfCuts(int n) {
        if(n == 1) {
            return 0;
        }
        if(n % 2 == 0) {
            return n / 2;
        }
        return n;
    }
}
