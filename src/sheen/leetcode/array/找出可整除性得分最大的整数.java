package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 找出可整除性得分最大的整数
 * @Date 2024/5/18 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 找出可整除性得分最大的整数 {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int res = 0;
        int v = 0;
        for(int divisor : divisors) {
            int count = 0;
            for(int num : nums) {
                if(num % divisor == 0) {
                    count++;
                }
            }

            if(count > v) {
                res = divisor;
                v = count;
            }
        }
        return res;
    }
}
