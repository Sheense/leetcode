package sheen.leetcode.dp;

public class 零钱兑换II {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) dp[i][0] = 1;
        for(int i=0;i<coins.length;i++) {
            for(int j=1;j<=amount;j++) {
                if(i>0) {
                    dp[i][j] += dp[i-1][j];
                }
                if(j-coins[i]>=0) {
                    dp[i][j] += dp[i][j-coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}
