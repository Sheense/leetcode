package sheen.leetcode.dp;

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()][p.length()];
        for(int i=0;i<p.length();i++) {
            if(i==0) dp[0][i] = s.charAt(0) == p.charAt(i) && p.charAt(i)=='.';
            else {
                if(p.charAt(i)=='.') dp[0][i] = false;
                else if(p.charAt(i)=='*') dp[0][i] =false;
           }
        }
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(p.charAt(j)=='*') {
                    dp[i][j] = dp[i][j-1] || (i==0&&dp[i][j-1])||(s.charAt(i)==p.charAt(j-1));
                }else if(p.charAt(j)=='.') {

                }else {

                }
            }
        }
        return false;
    }
}
