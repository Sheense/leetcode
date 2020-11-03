package com.company.array;

public class 统计字典序元音字符串的数目 {
    public int countVowelStrings(int n) {
        int dp[][] = new int[n][5];
        for(int i=0;i<n;i++) {
            for(int j=0;j<5;j++) {
                if(i == 0) dp[i][j] = 1;
                else {
                    for(int z = j;z>=0;z--) {
                        dp[i][j] += dp[i-1][z];
                    }
                }
            }
        }
        int res = 0;
        for(int j=0;j<5;j++) {
            res += dp[dp.length-1][j];
        }
        return res;
    }
}
