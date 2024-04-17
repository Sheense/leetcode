package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 统计整数数目
 * @Date 2024/1/16 00:59
 * @Created by sheen
 * @Description TODO
 */
public class 统计整数数目 {

    private String num;
    private int minSum;
    private int maxSum;
    private int mod = (int)Math.pow(10, 9) + 7;
    private int[][] dp;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.dp = new int[23][404];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        this.minSum = min_sum;
        this.maxSum = max_sum;

        return ((get(num2) - get(getSub(num1))) + mod)%mod;
    }

    public int get(String v) {
        this.num = new StringBuffer(v).reverse().toString();

        return dfs(num.length() - 1, 0, true);
    }

    public String getSub(String num) {
        char[] cs = num.toCharArray();
        int i = num.length() - 1;
        while (i >= 0 && cs[i] == '0') {
            i--;
        }
        cs[i]--;
        i++;
        while (i < cs.length) {
            cs[i] = '9';
            i++;
        }
        return String.valueOf(cs);
    }

    public int dfs(int i, int j, boolean limit) {
        if(j > maxSum) {
            return 0;
        }

        if(i == -1) {
            return j >= minSum ? 1 : 0;
        }

        if(!limit && this.dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        int up = limit ? this.num.charAt(i) - '0' : 9;
        for(int z = 0; z <= up; z++) {
            res += dfs(i - 1, j + z, limit && this.num.charAt(i) == z + '0');
            res %= mod;
        }

        if(!limit) {
            dp[i][j] = res;
        }
        return res;
    }
}
