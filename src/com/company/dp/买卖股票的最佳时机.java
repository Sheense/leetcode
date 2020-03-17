package com.company.dp;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.print(new 买卖股票的最佳时机().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int min = prices[0];
        int res = 0;
        for(int i=0;i<prices.length;i++) {
            res = res<prices[i]-min? prices[i]-min : res;
            min = prices[i] > min ? min : prices[i];
        }
        return res;
    }

}
