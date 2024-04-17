package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 购买两块巧克力
 * @Date 2023/12/29 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 购买两块巧克力 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(prices[0] + prices[1] <= money) {
            return money - (prices[0] + prices[1]);
        }
        return money;
    }
}
