package com.company.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 矩阵中的幸运数
 * @Date 2022/2/15 1:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵中的幸运数 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            int y = 0;
            for(int j = 0; j < matrix[i].length; j ++) {
                if(matrix[i][j] < matrix[i][y]) {
                    y = j;
                }
            }
            list.add(i * matrix[0].length + y);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            int v = list.get(i);
            int x = v / matrix[0].length;
            int y = v % matrix[0].length;
            boolean flag = true;
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[j][y] > matrix[x][y]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res.add(matrix[x][y]);
            }
        }
        return res;
    }
}
