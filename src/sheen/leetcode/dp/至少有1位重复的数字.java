package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 至少有1位重复的数字
 * @Date 2023/3/20 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 至少有1位重复的数字 {
    public static void main(String[] args) {
        至少有1位重复的数字 s = new 至少有1位重复的数字();
        System.out.println(s.numDupDigitsAtMostN(1000));
    }
    public int numDupDigitsAtMostN(int n) {
        String num = String.valueOf(n);
        int[][] dp = new int[num.length()][1 << 10];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return n + 1 - diff(0, num, true, 0, dp);
    }

    public int diff(int start, String n, boolean same, int mask, int[][] dp) {
        if(start == n.length()) {
            return 1;
        }
        if(!same && dp[start][mask] >= 0) {
            return dp[start][mask];
        }
        int res = 0;
        int t = same ? (n.charAt(start) - '0') : 9;
        for(int i = 0; i <= t; i++) {
            if((mask & (1 << i)) != 0) {
                continue;
            }

            int nextMask = mask == 0 && i == 0 ? mask : (mask | (1 << i));
            boolean nextSame = same && (i == t);
            res += diff(start + 1, n, nextSame, nextMask, dp);
        }
        dp[start][mask] = res;
        return res;
    }
}
