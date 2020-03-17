package com.company.dp;

import com.company.util.ArratyUtils;

import java.util.Scanner;

public class 编辑距离 {
    public static void main(String[] args) {
        编辑距离 j = new 编辑距离();
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();
        System.out.println(j.minDistance(word1,word2));
    }

    public int minDistance(String word1, String word2) {
        if((word1==null && word2 == null)||(word1.equals(word2))) return 0;
        if(word1==null||word1.equals("")) return word2.length();
        if(word2==null||word2.equals("")) return word1.length();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int dp[][] = new int[word1Chars.length][word2Chars.length];
        boolean flag = true;
        for(int i=0;i<word2Chars.length;i++) {
            if(word1Chars[0] == word2Chars[i] && flag) {
                dp[0][i] = i>0 ? dp[0][i-1] : 0;
                flag =false;
            } else {
                dp[0][i] = i>0 ? dp[0][i-1] + 1 : 1;
            }
        }

        for(int i=1;i<word1Chars.length;i++) {
            for(int j=0;j<word2Chars.length;j++){
                if(word1Chars[i]==word2Chars[j]) {
                    dp[i][j] = j==0 ? Math.min(i,dp[i-1][j]+1) : Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]+1), dp[i][j-1] +1);
                } else {
                    dp[i][j] = 1;
                    dp[i][j] += j==0 ? Math.min(i,dp[i-1][j]) : Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]),dp[i][j-1]) ;
                }
            }
        }
        ArratyUtils.print2(dp);
        return dp[word1Chars.length-1][word2Chars.length-1];
    }
}
