package sheen.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 数组的均值分割
 * @Date 2022/11/14 12:43 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组的均值分割 {

    //sum(A) / k == sum(all) / n
    //sum(all) * k == sum(A) * n;
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int m = nums.length / 2;
        boolean exist = false;
        int all = 0;
        for(int num : nums) {
            all += num;
        }

        for(int i = 1; i <= n; i++) {
            if(all * i % n == 0) {
                exist = true;
                break;
            }
        }

        if(!exist) {
            return false;
        }

        Set<Integer>[] dp = new Set[m + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for(int num : nums) {
            for(int i = m; i >= 1; i--) {
                for(int cur : dp[i - 1]) {
                    cur += num;
                    if(cur * n == all * i) {
                        return true;
                    }
                    dp[i].add(cur);
                }
            }
        }

        return false;
    }
}
