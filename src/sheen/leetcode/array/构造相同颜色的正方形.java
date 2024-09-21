package sheen.leetcode.array;

/**
 * @Classname 构造相同颜色的正方形
 * @Date 2024/8/31 00:19
 * @Created by sheen
 * @Description TODO
 */
public class 构造相同颜色的正方形 {
    public boolean canMakeSquare(char[][] grid) {
        int[][] arr = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for(int[] item : arr) {
            int count = 0;
            count += grid[item[0]][item[1]] == 'B' ? 1 : 0;
            count += grid[item[0]+1][item[1]] == 'B' ? 1 : 0;
            count += grid[item[0]+1][item[1]+1] == 'B' ? 1 : 0;
            count += grid[item[0]][item[1]+1] == 'B' ? 1 : 0;
            if(count == 0 || count == 1 || count == 4 || count == 3) {
                return true;
            }
        }

        return false;
    }

}
