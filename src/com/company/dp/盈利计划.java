package com.company.dp;

import java.util.*;

public class 盈利计划 {
    public static void main(String[] args) {
        盈利计划 s = new 盈利计划();
        System.out.println(s.profitableSchemes(5,3, new int[]{2, 2}, new int[]{2,3}));
    }


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][] dp = new long[n+1][minProfit+1];
        int mod = ((int)Math.pow(10, 9) + 7);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < group.length; i++) {
            long[][] copy = new long[n+1][minProfit+1];
            for (int j = 0; j <= n; j++) {
                for (int cost = 0; cost < dp[j].length; cost++) {
                    copy[j][cost] = dp[j][cost];
                }
                if (j >= group[i]) {
                    for(int cost = 0; cost < dp[j - group[i]].length; cost++) {
                        if (cost == minProfit || cost + profit[i] >= minProfit) {
                            copy[j][minProfit] += dp[j - group[i]][cost];
                            copy[j][minProfit] %= mod;
                        } else {
                            copy[j][cost + profit[i]] += dp[j - group[i]][cost];
                            copy[j][cost + profit[i]] %= mod;
                        }
                    }
                }
            }
            dp = copy;
        }
        return (int)dp[n][minProfit];
    }
}
