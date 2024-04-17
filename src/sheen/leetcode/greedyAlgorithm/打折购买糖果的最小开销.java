package sheen.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @Classname 打折购买糖果的最小开销
 * @Date 2023/5/6 5:31 下午
 * @Created by sheen
 * @Description TODO
 */
public class 打折购买糖果的最小开销 {
    public static void main(String[] args) {
        打折购买糖果的最小开销 s = new 打折购买糖果的最小开销();
        System.out.println(s.minimumCost(new int[]{6,5,7,9,2,2}));
    }
    public int minimumCost(int[] cost) {
        if(cost.length <= 2) {
            if(cost.length == 2) {
                return cost[0] + cost[1];
            }
            return cost[0];
        }
        Arrays.sort(cost);
        int res = 0;
        for(int i = cost.length - 1; i >= 0; i--) {
            res += cost[i--];
            if(i >= 0) {
                res += cost[i--];
            }
        }
        return res;
    }
}
