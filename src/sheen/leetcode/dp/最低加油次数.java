package sheen.leetcode.dp;

/**
 * @Classname 最低加油次数
 * @Date 2022/7/2 2:41 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最低加油次数 {
    public static void main(String[] args) {
        最低加油次数 s = new 最低加油次数();
        System.out.println(s.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}));
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        for(int i = 0; i < stations.length; i++) {
            for(int j = i; j >= 0; j--) {
                if(dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] >= target) {
                res = Math.min(i, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
