package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 英雄的力量
 * @Date 2023/8/1 00:13
 * @Created by sheen
 * @Description TODO
 *
 * 突破点：dp[i]表示所有以num[i]结尾的序列的最小值的和
 */
public class 英雄的力量 {
    public static void main(String[] args) {
        英雄的力量 s = new 英雄的力量();
        System.out.println(s.sumOfPower(new int[]{2,1,4}));
    }
    public int sumOfPower(int[] nums) {
        int mod = (int)Math.pow(10, 9) + 7;
        Arrays.sort(nums);
        long[] dp = new long[nums.length];
        long[] pre = new long[nums.length];
        dp[0] = nums[0];
        pre[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = pre[i - 1] + nums[i];
            pre[i] = dp[i] + pre[i - 1];
            dp[i] %= mod;
            pre[i] %= mod;
        }

        long res = 0;
        for(int i = 0; i < nums.length; i++) {
            long v = (long)nums[i] * nums[i] % mod;
            v = v * dp[i] % mod;
            res += v;
            res %= mod;
        }

        return (int) res;


    }
}
