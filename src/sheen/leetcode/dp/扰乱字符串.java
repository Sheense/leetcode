package sheen.leetcode.dp;

public class 扰乱字符串 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;

        boolean dp[][][] = new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++) {
                dp[i][j][1] = s1.charAt(i)==s2.charAt(j);
            }
        }
        for(int len=2;len<=s1.length();len++) {
            for(int i=0;i<s1.length()-len+1;i++) {
                for(int j=0;j<s2.length()-len+1;j++) {
                    for(int k=1;k<len;k++) {
                        dp[i][j][len] |= dp[i][j][k]&&dp[i+k][j+k][len-k] || dp[i][j+len-k][k]&&dp[i+k][j][len-k];
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }
}
