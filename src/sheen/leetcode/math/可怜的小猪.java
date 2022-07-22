package sheen.leetcode.math;

/**
 * @Classname 可怜的小猪
 * @Date 2021/11/25 12:53 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可怜的小猪 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return  (int)Math.ceil(Math.log(buckets)/Math.log(minutesToTest / minutesToDie + 1));
    }
}
