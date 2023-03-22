package sheen.leetcode.array;

/**
 * @Classname 最大的以1为边界的正方形
 * @Date 2023/2/17 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最大的以1为边界的正方形 {
    public int largest1BorderedSquare(int[][] grid) {
        for(int i = Math.min(grid.length, grid[0].length); i >= 1; i--) {
            for(int x = 0; x <= grid.length - i; x++) {
                for(int y = 0; y <= grid[0].length - i; y++) {
                    if(isSquare(x, y, grid, i)) {
                        return i * i;
                    }
                }
            }
        }
        return 0;
    }

    public int getCount(int[][] grid, int x, int y, int len) {
        int res = 0;
        for(int i = x; i < x + len; i++) {
            for(int j = y; j < y + len; j++) {
                if(grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isSquare(int x, int y, int[][] grid, int len) {
        int downX = x + len - 1;
        int rightY = y + len - 1;
        for(int i = 0; i < len; i++) {
            if(grid[x][i + y] == 0 || grid[downX][i + y] == 0) {
                return false;
            }

            if(grid[x + i][y] == 0 || grid[x + i][rightY] == 0) {
                return false;
            }
        }

        return true;
    }
}
