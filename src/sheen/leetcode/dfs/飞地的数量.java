package sheen.leetcode.dfs;

/**
 * @Classname 飞地的数量
 * @Date 2022/2/12 10:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 飞地的数量 {
    public static void main(String[] args) {
        飞地的数量 s = new 飞地的数量();
        System.out.println(s.numEnclaves(new int[][]{
                {0,0,1,0},
                {1,1,0,0},
                {1,0,1,0},
                {0,0,0,0}
        }));
    }
    private int[][] mat = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        int all = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) all++;
            }
        }
        int count = 0;
        boolean[][] check = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1 && !check[0][i]) {
                count += dfs(0, i, grid, check);
            }
            if(grid[grid.length - 1][i] == 1 && !check[grid.length - 1][i]) {
                count += dfs(grid.length - 1, i, grid, check);
            }
        }

        for(int i = 1; i < grid.length - 1; i++) {
            if(grid[i][0] == 1 && !check[i][0]) {
                count += dfs(i, 0, grid, check);
            }
            if(grid[i][grid[0].length - 1] == 1 && !check[i][grid[0].length - 1]) {
                count += dfs(i, grid[0].length - 1, grid, check);
            }
        }
        return all - count;
    }

    public int dfs(int x, int y, int[][] grid, boolean [][] check) {
        if(grid[x][y] == 0) {
            return 0;
        }
        check[x][y] = true;
        int res = 1;
        for(int i = 0; i < mat.length; i++) {
            int x1 = x + mat[i][0];
            int y1 = y + mat[i][1];
            if(x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && !check[x1][y1] && grid[x1][y1] == 1) {
                res += dfs(x1, y1, grid, check);
            }
        }
        return res;
    }
}
