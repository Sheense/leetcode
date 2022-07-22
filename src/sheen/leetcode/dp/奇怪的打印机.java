package sheen.leetcode.dp;

public class 奇怪的打印机 {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j<s.length(); j++) {
                if(j == i) {
                    dp[i][j] = 1;
                }else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        int min = Integer.MAX_VALUE;
                        for(int z = i; z < j; z++) {
                            min = Math.min(min, dp[i][z]+dp[z+1][j]);
                        }
                        dp[i][j] = min;
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
