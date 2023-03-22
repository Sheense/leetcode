package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Classname 你能构造出连续值的最大数目
 * @Date 2023/2/4 12:57 上午
 * @Created by sheen
 * @Description TODO
 */
public class 你能构造出连续值的最大数目 {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 0;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= res + 1) {
                res += coins[i];
            }
        }

        return res + 1;
    }
}
