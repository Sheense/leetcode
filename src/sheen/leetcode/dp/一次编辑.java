package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

public class 一次编辑 {
    public static void main(String[] args) {
        一次编辑 s = new 一次编辑();
        System.out.println(s.oneEditAway("pale","ple"));
    }
    public boolean oneEditAway(String first, String second) {
        if(first.length() == 0 ) return second.length()<=1;
        if(second.length() == 0) return first.length()<=1;
        if(first.equals(second)) return true;
        int[][] dp = new int[first.length()][second.length()];
        for(int i=0;i<first.length();i++) {
            for(int j=0;j<second.length();j++) {
                if(i == 0 || j == 0) {
                    if(i == 0 && j == 0) {
                        dp[0][0] = first.charAt(0) == second.charAt(0) ? 0 : 1;
                    } else if(i == 0) {
                        dp[0][j] = first.charAt(0) == second.charAt(j) ? j : dp[0][j-1]+1;
                    } else {
                        dp[i][0] = first.charAt(i) == second.charAt(0) ? i : dp[i-1][0]+1;
                    }
                } else {
                    if (first.charAt(i) == second.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
            }
        }
        ArrayUtils.print2(dp);
        return dp[first.length()-1][second.length()-1] <= 1;
    }
}
