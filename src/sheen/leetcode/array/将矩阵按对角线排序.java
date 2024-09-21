package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 将矩阵按对角线排序
 * @Date 2024/4/29 00:05
 * @Created by sheen
 * @Description TODO
 */
public class 将矩阵按对角线排序 {
    public int[][] diagonalSort(int[][] mat) {
        for(int i = 0; i < mat[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            int x = 0;
            int y = i;
            while (x < mat.length && y < mat[0].length) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            x = 0;
            y = i;
            Collections.sort(list);
            for(int v : list) {
                mat[x++][y++] = v;
            }
        }

        for(int i = 1; i < mat.length; i++) {
            List<Integer> list = new ArrayList<>();
            int x = i;
            int y = 0;
            while (x < mat.length && y < mat[0].length) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            x = i;
            y = 0;
            Collections.sort(list);
            for(int v : list) {
                mat[x++][y++] = v;
            }
        }

        return mat;
    }
}
