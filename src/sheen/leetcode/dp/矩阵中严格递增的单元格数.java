package sheen.leetcode.dp;

import java.util.*;

/**
 * @Classname 矩阵中严格递增的单元格数
 * @Date 2024/6/19 00:36
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中严格递增的单元格数 {
    public int maxIncreasingCells(int[][] mat) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.computeIfAbsent(mat[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for(int key : map.keySet()) {
            List<int[]> pos = map.get(key);
            List<Integer> res = new ArrayList<>();
            for(int[] item : pos) {
                res.add(Math.max(row[item[0]], col[item[1]]) + 1);
            }

            for(int i = 0; i < pos.size(); i++) {
                int d = res.get(i);
                row[pos.get(i)[0]] = Math.max(row[pos.get(i)[0]], d);
                col[pos.get(i)[1]] = Math.max(col[pos.get(i)[1]], d);
            }
        }
        return Arrays.stream(row).max().getAsInt();
    }
}
