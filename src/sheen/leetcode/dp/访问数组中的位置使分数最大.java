package sheen.leetcode.dp;

/**
 * @Classname 访问数组中的位置使分数最大
 * @Date 2024/6/14 01:07
 * @Created by sheen
 * @Description TODO
 */
public class 访问数组中的位置使分数最大 {
    public long maxScore(int[] nums, int x) {
        long[] dp = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        long res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int p = nums[i] % 2;
            long cur = Math.max(dp[p] + nums[i], dp[1 - p] - x + nums[i]);
            res = Math.max(cur, res);
            dp[p] = Math.max(dp[p], cur);
        }
        return res;
    }
}
