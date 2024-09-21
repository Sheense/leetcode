package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 求出最长好子序列I
 * @Date 2024/9/6 00:54
 * @Created by sheen
 * @Description TODO
 */
public class 求出最长好子序列I {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length][51];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            for(int l = 0; l <= k; l++) {
                for(int j = 0; j < i; j++) {
                    int add = nums[i] != nums[j] ? 1 : 0;
                    if(l - add >= 0 && dp[j][l - add] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l - add] + 1);
                    }
                }
                ans = Math.max(ans, dp[i][l]);
            }
        }
        return ans;
    }
}
