package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二维网格迁移
 * @Date 2022/7/20 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二维网格迁移 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k-- != 0) {
            int[][] newArr = new int[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[i].length; j++) {
                    if(j == grid[i].length - 1 && i == grid.length - 1) {
                        newArr[0][0] = grid[i][j];
                    }else if(j == grid[i].length - 1) {
                        newArr[i + 1][0] = grid[i][j];
                    }else {
                        newArr[i][j + 1] = grid[i][j];
                    }
                }
            }
            grid = newArr;
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            List<Integer> item = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++) {
                item.add(grid[i][j]);
            }
            res.add(item);
        }
        return res;
    }
}
