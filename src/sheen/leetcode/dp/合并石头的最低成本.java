package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Classname 合并石头的最低成本
 * @Date 2023/4/4 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 合并石头的最低成本 {
    public static void main(String[] args) {
        合并石头的最低成本 s = new 合并石头的最低成本();
        System.out.println(s.mergeStones(new int[]{3,5,1,2,6}, 3));
    }
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int MAX = Integer.MAX_VALUE - 100000;
        int[] pre = new int[stones.length];
        int[][] dp = new int[stones.length][stones.length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], MAX);
        }
        for(int i = 0; i < stones.length; i++) {
            dp[i][i] = 0;
            if(i == 0) {
                pre[i] = stones[0];
            }else {
                pre[i] = pre[i - 1] + stones[i];
            }
        }

        for(int len = 2; len <= n; len++) {
            for(int left = 0; left < n && left + len - 1 < n; left++) {
                int right = left + len - 1;
                for(int p = left; p < right; p += (k - 1)) {
                    dp[left][right] = Math.min(dp[left][p] + dp[p + 1][right], dp[left][right]);
                }
                if((right - left) % (k - 1) == 0) {
                    dp[left][right] += left == 0 ? pre[right] : pre[right] - pre[left - 1];
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
