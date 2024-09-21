package sheen.leetcode.array;

/**
 * @Classname 查询网格图中每一列的宽度
 * @Date 2024/4/27 00:22
 * @Created by sheen
 * @Description TODO
 */
public class 查询网格图中每一列的宽度 {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for(int j = 0; j < grid.length; j++) {
                max = Math.max(max, String.valueOf(grid[j][i]).length());
            }
            ans[i] = max;
        }
        return ans;
    }
}
