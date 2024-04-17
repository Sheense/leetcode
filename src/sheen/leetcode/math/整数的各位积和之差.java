package sheen.leetcode.math;

/**
 * @Classname 整数的各位积和之差
 * @Date 2023/8/9 00:01
 * @Created by sheen
 * @Description TODO
 */
public class 整数的各位积和之差 {
    public int subtractProductAndSum(int n) {
        int and = 0;
        int mu = 1;
        while (n != 0) {
            and += n % 10;
            mu *= n % 10;
            n /= 10;
        }
        return mu - and;
    }
}
