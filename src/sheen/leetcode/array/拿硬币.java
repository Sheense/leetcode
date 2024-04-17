package sheen.leetcode.array;

/**
 * @Classname 拿硬币
 * @Date 2023/9/20 00:03
 * @Created by sheen
 * @Description TODO
 */
public class 拿硬币 {
    public int minCount(int[] coins) {
        int res = 0;
        for(int coin : coins) {
            if(coin % 2 == 1) {
                res += (coin / 2) + 1;
            }else {
                res += (coin / 2);
            }
        }
        return res;
    }
}
