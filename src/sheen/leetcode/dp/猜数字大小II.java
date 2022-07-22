package sheen.leetcode.dp;

/**
 * @Classname 猜数字大小II
 * @Date 2021/11/12 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 猜数字大小II {
    public static void main(String[] args) {
        猜数字大小II s = new 猜数字大小II();
        System.out.println(s.getMoneyAmount(10));
    }
    public int getMoneyAmount(int n) {
        int[][]  dp = new int[n][n];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n - i ; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for(int z = j; z <= j + i; z++) {
                    if(z == j) {
                        dp[j][j + i] = Math.min(dp[j][j + i], z + 1 + dp[j + 1][j + i]);
                    }else if(z == j + i) {
                        dp[j][j + i] = Math.min(dp[j][j+i], z + 1 + dp[j][j + i - 1]);
                    }else {
                        int value = z + 1 + Math.max(dp[j][z - 1], dp[z + 1][j + i]);
                        dp[j][j + i] = Math.min(value, dp[j][j+i]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
