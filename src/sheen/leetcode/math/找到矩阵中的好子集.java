package sheen.leetcode.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 找到矩阵中的好子集
 * @Date 2024/6/25 01:11
 * @Created by sheen
 * @Description TODO
 */
public class 找到矩阵中的好子集 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            int mask = 0;
            for(int j = 0; j < grid[i].length; j++) {
                mask |= grid[i][j] << j;
            }
            if (mask == 0) {
                return Arrays.asList(i);
            }
            map.put(mask, i);
        }

        for(Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            for(Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                if ((e1.getKey() & e2.getKey()) == 0) {
                    int k1 = e1.getValue();
                    int k2 = e2.getValue();
                    return k1 > k2 ? Arrays.asList(k2, k1) : Arrays.asList(k1, k2);
                }
            }
        }
        return Arrays.asList();
    }
}
