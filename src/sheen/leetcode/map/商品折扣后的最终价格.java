package sheen.leetcode.map;


/**
 * @Classname 商品折扣后的最终价格
 * @Date 2022/9/1 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 商品折扣后的最终价格 {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return res;
    }
}
