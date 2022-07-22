package sheen.leetcode.dp;

public class 最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        最佳买卖股票时机含冷冻期 s = new 最佳买卖股票时机含冷冻期();

    }

    public int maxProfit(int[] prices, int fee) {
        if(prices.length==0) return 0;
        int [][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++) {
            if(i==0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                continue;
            }else {
                dp[i][0] = Math.max(dp[i-1][1]+prices[i]-fee, dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
            }
        }
        return dp[prices.length-1][0];
    }
}
