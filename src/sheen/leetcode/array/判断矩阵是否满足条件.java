package sheen.leetcode.array;

/**
 * @Classname 判断矩阵是否满足条件
 * @Date 2024/8/29 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 判断矩阵是否满足条件 {
    public boolean satisfiesConditions(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i + 1 < grid.length) {
                    if(grid[i][j] != grid[i + 1][j]) return false;
                }

                if(j + 1 < grid[0].length) {
                    if(grid[i][j] == grid[i][j + 1]) return false;
                }
            }
        }
        return true;
    }
}
