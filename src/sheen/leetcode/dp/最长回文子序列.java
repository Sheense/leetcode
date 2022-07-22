package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 最长回文子序列
 * @Date 2021/8/12 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        最长回文子序列 s = new 最长回文子序列();
        System.out.println(s.longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int [s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) {
                Arrays.fill(dp[0], 1);
            }else {
                for(int j = 0; j < s.length() - i; j++) {
                    if(s.charAt(j) == s.charAt(j + i)) {
                        int left = j + 1;
                        int right = j + i - 1;
                        if(left > right) {
                            dp[i][j] = 2;
                        }else {
                            dp[i][j] = dp[i-2][left] + 2;
                        }
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j+1], dp[i-1][j]);
                    }
                }
            }
        }
        return dp[s.length()-1][0];
    }
}
