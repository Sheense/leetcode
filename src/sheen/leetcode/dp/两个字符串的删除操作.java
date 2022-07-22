package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 两个字符串的删除操作
 * @Date 2021/9/25 12:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两个字符串的删除操作 {
    public static void main(String[] args) {
        两个字符串的删除操作 s = new 两个字符串的删除操作();
        System.out.println(s.minDistance("sea", "eat"));
    }
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < dp.length; i++) {
            if(word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = i;
            }else if(i > 0){
                dp[i][0] = dp[i-1][0] + 1;
            }else {
                dp[i][0] = 2;
            }
        }
        for(int j = 0; j < dp[0].length; j++) {
            if(word1.charAt(0) == word2.charAt(j)) {
                dp[0][j] = j;
            }else if(j > 0){
                dp[0][j] = dp[0][j-1] + 1;
            }else {
                dp[0][j] = 2;
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) + 1, dp[i-1][j-1] + 2);
                }
            }
        }
        ArrayUtils.print2(dp);
        return dp[word1.length()-1][word2.length()-1];
    }
}
