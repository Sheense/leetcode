package sheen.leetcode.math;

/**
 * @Classname 取整购买后的账户余额
 * @Date 2024/6/12 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 取整购买后的账户余额 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 >= 5) {
            return 100 - (purchaseAmount + (10 - purchaseAmount % 10));
        }else {
            return 100 - (purchaseAmount - purchaseAmount % 10);
        }
    }
}
