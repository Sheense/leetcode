package sheen.leetcode.dfs;

/**
 * @Classname 检查骑士巡视方案
 * @Date 2023/9/13 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 检查骑士巡视方案 {
    public static void main(String[] args) {
        检查骑士巡视方案 s= new 检查骑士巡视方案();
        System.out.println(s.checkValidGrid(new int[][]{{0,11,16,5,20},{17,4,19,10,15},
                {12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}));
    }
    public boolean checkValidGrid(int[][] grid) {
        int[][] mat = new int[][]{{-2, -1}, {2, 1}, {-2, 1}, {2, -1}, {1, 2}, {-1, -2}, {-1, 2}, {1, -2}};

        int x = 0;
        int y = 0;
        int index = grid[x][y];
        while (index < grid.length * grid[0].length - 1) {
            boolean flag = false;
            for(int[] arr : mat) {
                int nextX = x + arr[0];
                int nextY = y + arr[1];
                if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                    if(grid[nextX][nextY] == index + 1) {
                        flag = true;
                        index++;
                        x = nextX;
                        y = nextY;
                        break;
                    }
                }
            }
            if(!flag) {
                break;
            }
        }
        return index == grid.length * grid[0].length - 1  && grid[0][0] == 0;
    }
}
