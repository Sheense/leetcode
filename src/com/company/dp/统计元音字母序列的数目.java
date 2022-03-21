package com.company.dp;

import java.util.Arrays;

/**
 * @Classname 统计元音字母序列的数目
 * @Date 2022/1/17 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计元音字母序列的数目 {
    public static void main(String[] args) {
        统计元音字母序列的数目 s = new 统计元音字母序列的数目();
        System.out.println(s.countVowelPermutation(5));
    }
    private static final int a = 0;
    private static final int e = 1;
    private static final int i = 2;
    private static final int o = 3;
    private static final int u = 4;
    private static final int MOD = (int)Math.pow(10, 9) + 7;
    public int countVowelPermutation(int n) {
        long[][] dp1 = new long[n][5];
        Arrays.fill(dp1[0], 1);
        for(int j = 1; j < n; j++) {
            for(int z = 0; z < 5; z++) {
                switch (z) {
                    case a: {
                        dp1[j][e] += dp1[j - 1][a];
                        dp1[j][e] %= MOD;
                        break;
                    }
                    case e: {
                        dp1[j][i] += dp1[j - 1][e];
                        dp1[j][a] += dp1[j - 1][e];
                        dp1[j][i] %= MOD;
                        dp1[j][a] %= MOD;
                        break;
                    }
                    case i: {
                        dp1[j][a] += dp1[j - 1][i];
                        dp1[j][e] += dp1[j - 1][i];
                        dp1[j][o] += dp1[j - 1][i];
                        dp1[j][u] += dp1[j - 1][i];
                        dp1[j][a] %= MOD;
                        dp1[j][e] %= MOD;
                        dp1[j][o] %= MOD;
                        dp1[j][u] %= MOD;
                        break;
                    }
                    case o: {
                        dp1[j][i] += dp1[j - 1][o];
                        dp1[j][u] += dp1[j - 1][o];
                        dp1[j][i] %= MOD;
                        dp1[j][u] %= MOD;
                        break;
                    }
                    case u: {
                        dp1[j][a] += dp1[j - 1][u];
                        dp1[j][a] %= MOD;
                        break;
                    }
                }
            }
        }

        long res = 0;
        for(int i = 0; i < 5; i++) {
            res += dp1[n-1][i];
            res %= MOD;
        }
        return (int)res;
    }

}
