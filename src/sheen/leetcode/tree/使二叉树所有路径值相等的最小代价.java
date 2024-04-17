package sheen.leetcode.tree;

/**
 * @Classname 使二叉树所有路径值相等的最小代价
 * @Date 2024/2/28 01:17
 * @Created by sheen
 * @Description TODO
 */
public class 使二叉树所有路径值相等的最小代价 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for(int i = cost.length - 2; i >= 0; i-=2) {
            ans += Math.abs(cost[i] - cost[i+1]);
            cost[i / 2] += Math.max(cost[i], cost[i+1]);
        }
        return ans;
    }
}
