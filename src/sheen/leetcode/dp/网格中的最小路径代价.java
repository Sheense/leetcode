package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 网格中的最小路径代价
 * @Date 2023/5/6 3:48 下午
 * @Created by sheen
 * @Description TODO
 */
public class 网格中的最小路径代价 {
    public static void main(String[] args) {
        网格中的最小路径代价 s = new 网格中的最小路径代价();
        System.out.println(s.minPathCost(new int[][]{{5,1,2},{4,0,3}}, new int[][]{{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}}));
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int z = 0; z < grid[0].length; z++) {
                    min = Math.min(moveCost[grid[i - 1][z]][j] + dp[i - 1][z], min);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}
