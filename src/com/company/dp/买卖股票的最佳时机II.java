package com.company.dp;

public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
        买卖股票的最佳时机II s = new 买卖股票的最佳时机II();
        System.out.println(s.maxProfit(new int[]{0,5,5,6,2,1,1,3}));
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int min = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]>prices[i-1]&&(i+1==prices.length||prices[i+1]<=prices[i])) {
                res += prices[i] - min;
            }
            if(prices[i]<=prices[i-1]&&(i+1==prices.length||prices[i+1]>=prices[i])) {
                min = prices[i];
            }
        }
        return res;
    }
}
