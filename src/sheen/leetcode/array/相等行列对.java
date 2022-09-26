package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 相等行列对
 * @Date 2022/7/24 10:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 相等行列对 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> row = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            String str = "";
            for(int j = 0; j < grid[i].length; j++) {
                str += grid[i][j] + "#";
            }
            row.put(str, row.getOrDefault(str, 0) + 1);
        }
        Map<String, Integer> col = new HashMap<>();
        for(int i = 0; i < grid[0].length; i++) {
            String str = "";
            for(int j = 0; j < grid.length; j++) {
                str += grid[j][i] + "#";
            }
            col.put(str, col.getOrDefault(str, 0) + 1);
        }
        int res = 0;
        for(String str : row.keySet()) {
            res += row.get(str) * col.getOrDefault(str, 0);
        }
        return res;
    }
}
