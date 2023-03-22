package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 不同的子序列II
 * @Date 2022/10/14 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 不同的子序列II {
    public static void main(String[] args) {
        不同的子序列II s = new 不同的子序列II();
        System.out.println(s.distinctSubseqII("abc"));
    }
    public int distinctSubseqII(String s) {
        int[] dp = new int[s.length()];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int mod = (int)Math.pow(10,9) + 7;

        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < last.length; j++) {
                if(last[j] != -1) {
                    dp[i] += dp[last[j]];
                    dp[i] %= mod;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for(int i = 0; i < last.length; i++) {
            if(last[i] != -1) {
                res += dp[last[i]];
                res %= mod;
            }
        }
        return res;
    }
}
