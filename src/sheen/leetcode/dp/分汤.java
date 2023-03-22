package sheen.leetcode.dp;

import java.util.concurrent.locks.LockSupport;

/**
*@Classname 分汤
*@Date 2022/11/21 12:26 上午
*@Created by sheen
*@Description TODO
*/
public class 分汤 {
    public static void main(String[] args) {
        分汤 s = new 分汤();
        System.out.println(s.soupServings(50));
    }
    public double soupServings(int n) {
        n = (int)Math.ceil((double) n / 25);
        if(n >= 179) {
            return 1.0;
        }

        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for(int i = 1; i < dp.length; i++) {
            dp[0][i] = 1;
            dp[i][0] = 0;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] +
                        dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] +
                        dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] +
                        dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]) / 4;
            }
        }


        return dp[dp.length - 1][dp.length - 1];
    }
}
