package com.company.dp;

import com.company.util.ArrayUtils;

public class 不同的子序列 {

    public static void main(String[] args) {
        不同的子序列 s = new 不同的子序列();
        System.out.println(s.numDistinct("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {
        if(s.length()==0||t.length()==0) return 0;
        int [][] dp = new int[t.length()][s.length()];
        for(int i=0;i<t.length();i++) {
            for(int j=0;j<s.length();j++) {
                if(i==0) {
                    if(j==0) dp[i][j] = t.charAt(i) == s.charAt(j) ? 1 : 0;
                    else {
                        dp[i][j] = t.charAt(i) == s.charAt(j) ? dp[i][j-1] + 1 :  dp[i][j-1];
                    }
                    continue;
                }
                if(j==0) dp[i][j]=0;
                else if(s.charAt(j)==t.charAt(i)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        ArrayUtils.print2(dp);
        return dp[t.length()-1][s.length()-1];
    }
}
