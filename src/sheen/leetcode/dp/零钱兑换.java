package sheen.leetcode.dp;

public class 零钱兑换 {
    public static void main(String[] args) {
        零钱兑换 s = new 零钱兑换();
        System.out.println(s.coinChange(new int[]{1,2,5},11));
    }
    /*public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<dp.length;i++) dp[i] = Integer.MAX_VALUE;
        for(int i=1;i<=amount;i++) {
            for(int j = 0;j<coins.length;j++) {
                int z = 1;
                int min = Integer.MAX_VALUE;
                while(coins[j]*z<=i) {
                    if(dp[i-coins[j]*z]!=Integer.MAX_VALUE) min = min>dp[i-coins[j]*z]+z ? dp[i-coins[j]*z] + z : min;
                    z++;
                }
                if(min!=Integer.MAX_VALUE) {
                    dp[i] = dp[i]==0 ?min: dp[i]>min ? min : dp[i];
                }
            }
        }
        int res = dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
        return res;
    }*/

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount;i++) {
            dp[i] = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++) {
                if(i-coins[j]>=0 ) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
