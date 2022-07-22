package sheen.leetcode.array;

/**
 * @Classname 保持城市天际线
 * @Date 2021/12/13 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] column = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for(int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            row[i] = max;
        }

        for(int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for(int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            column[i] = max;
        }

        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int min = Math.min(row[i], column[j]);
                res += min - grid[i][j];
            }
        }
        return res;
    }
}
