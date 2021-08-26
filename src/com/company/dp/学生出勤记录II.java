package com.company.dp;

/**
 * @Classname 学生出勤记录II
 * @Date 2021/8/18 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 学生出勤记录II {
    public static void main(String[] args) {
        学生出勤记录II s = new 学生出勤记录II();
        System.out.println(s.checkRecord(2));
    }
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        int mod = (int)Math.pow(10, 9) + 7;
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                for(int z = 0; z < dp[i][j].length; z++){
                    dp[i][j][0] += dp[i-1][j][z];
                    dp[i][j][0] %= mod;
                }
            }

            for(int z = 0; z < 3; z++) {
                dp[i][1][0] += dp[i-1][0][z];
                dp[i][1][0] %= mod;
            }

            for(int j = 0; j < dp[i].length; j++) {
                for(int z = 1; z <=2; z++) {
                    dp[i][j][z] += dp[i-1][j][z-1];
                    dp[i][j][z] %= mod;
                }
            }
        }
        int sum = 0;
        for(int j = 0; j < 2; j++) {
            for(int z = 0; z <= 2; z++) {
                sum += dp[n][j][z];
                sum %= mod;
            }
        }

        return sum;
    }
}
