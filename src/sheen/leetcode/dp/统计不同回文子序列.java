package sheen.leetcode.dp;

/**
 * @Classname 统计不同回文子序列
 * @Date 2022/6/10 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计不同回文子序列 {
    public static void main(String[] args) {
        统计不同回文子序列 s = new 统计不同回文子序列();
        System.out.println(s.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
    public int countPalindromicSubsequences(String s) {
        int MOD = 1000000007;
        int[][][] dp = new int[s.length()][s.length()][4];

        for(int len = 1; len <= s.length(); len++) {
            if(len == 1) {
                for(int i = 0; i < s.length(); i++) {
                    dp[i][i][s.charAt(i) - 'a']++;
                }
                continue;
            }

            for(int i = 0; i <= s.length() - len; i++) {
                for(int j = 0; j < 4; j++) {
                    char c = (char)('a' + j);
                    char left = s.charAt(i);
                    char right = s.charAt(i + len - 1);
                    if(left == c && right == c) {
                        dp[i][i + len - 1][j] = 2;
                        if(len > 2) {
                            for(int q = 0; q < 4; q++) {
                                dp[i][i + len - 1][j] += dp[i + 1][i + len - 2][q];
                                dp[i][i + len - 1][j] %= MOD;
                            }
                        }
                    }else if(left == c && right != c) {
                        dp[i][i + len - 1][j] = dp[i][i + len - 2][j];
                    }else if(left != c && right == c) {
                        dp[i][i + len - 1][j] = dp[i + 1][i + len - 1][j];
                    }else {
                        if(len > 2) {
                            dp[i][i + len - 1][j] = dp[i + 1][i + len - 2][j];
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < 4; i++) {
            res += dp[0][s.length() - 1][i];
            res %= MOD;
        }

        return res;
    }
}