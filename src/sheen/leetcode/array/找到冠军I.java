package sheen.leetcode.array;

/**
 * @Classname 找到冠军I
 * @Date 2024/4/12 00:02
 * @Created by sheen
 * @Description TODO
 */
public class 找到冠军I {
    public int findChampion(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            int count = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if(i != j && grid[i][j] == 1) {
                    count++;
                }
            }

            if(count == grid.length - 1) {
                return i;
            }
        }
        return -1;
    }
}
