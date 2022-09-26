package sheen.leetcode.math;

/**
 * @Classname 最小偶倍数
 * @Date 2022/9/18 11:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小偶倍数 {
    public int smallestEvenMultiple(int n) {
        if(n % 2 == 1) {
            return n * 2;
        }else {
            return n;
        }
    }

}
