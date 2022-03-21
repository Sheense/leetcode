package com.company.array;

import java.util.Arrays;

/**
 * @Classname 股票平滑下跌阶段的数目
 * @Date 2021/12/19 10:56 上午
 * @Created by sheen
 * @Description TODO
 */
public class 股票平滑下跌阶段的数目 {
    public static void main(String[] args) {
        股票平滑下跌阶段的数目 s = new 股票平滑下跌阶段的数目();
        System.out.println(s.getDescentPeriods(new int[] {3,2,1,4}));
    }
    public long getDescentPeriods(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, 1);
        long res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] + 1 == prices[i - 1]) {
                dp[i] += dp[i - 1];
            }
        }
        for(int i = 0; i < prices.length; i++) {
            res += dp[i];
        }
        return res;
    }
}
