package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Classname 需要添加的硬币的最小数量
 * @Date 2024/3/30 00:17
 * @Created by sheen
 * @Description TODO
 */
public class 需要添加的硬币的最小数量 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int x = 1;
        int res = 0;
        int i = 0;
        while (x <= target) {
            if(i < coins.length && coins[i] <= x) {
                x += coins[i];
                i++;
            }else {
                res ++;
                x *= 2;
            }
        }
        return res;
    }
}
