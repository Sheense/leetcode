package sheen.leetcode.math;

/**
 * @Classname K件物品的最大和
 * @Date 2023/7/5 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class K件物品的最大和 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        if(numOnes >= k) {
            return k;
        }
        res += numOnes;
        k -= numOnes;
        if(numZeros >= k) {
            return res;
        }
        k -= numZeros;
        res -= k;
        return res;
    }
}
