package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @Classname 矩阵中的局部最大值
 * @Date 2023/3/1 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中的局部最大值 {
    public static void main(String[] args) {
        矩阵中的局部最大值 s = new 矩阵中的局部最大值();
        ArrayUtils.print2(s.largestLocal(new int[][]
                {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}
));
    }
    public int[][] largestLocal(int[][] grid) {
        List<List<List<Integer>>> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            List<List<Integer>> row = new ArrayList<>();
            for(int j = 0; j < grid.length - 2; j++) {
                row.add(Arrays.asList(grid[i][j], grid[i][j + 1], grid[i][j + 2]));
            }
            list.add(row);
        }

        int[][] res = new int[grid.length - 2][grid.length - 2];
        for(int i = 0; i < res.length; i++) {

            for(int j = 0; j < res[i].length; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.addAll(list.get(i).get(j));
                set.addAll(list.get(i + 1).get(j));
                set.addAll(list.get(i + 2).get(j));
                res[i][j] = set.last();
            }
        }
        return res;
    }
}
