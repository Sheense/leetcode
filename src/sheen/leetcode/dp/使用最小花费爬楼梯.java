package sheen.leetcode.dp;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1) return 0;
        int first = cost[0];
        int second = cost[1];
        for(int i=2;i<cost.length;i++) {
            int item = Math.min(first,second)+cost[i];
            first = second;
            second = item;
        }
        return Math.min(first, second);
    }
}
