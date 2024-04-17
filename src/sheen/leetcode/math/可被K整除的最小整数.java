package sheen.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 可被K整除的最小整数
 * @Date 2023/5/10 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可被K整除的最小整数 {
    public int smallestRepunitDivByK(int k) {
        int yu =  1 % k;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        while (yu != 0) {
            yu = (yu * 10 + 1) % k;
            if(set.contains(yu)) {
                return -1;
            }
            set.add(yu);
            res++;
        }
        return res;
    }
}
