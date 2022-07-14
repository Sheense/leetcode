package com.company.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 判断矩阵是否是一个X矩阵
 * @Date 2022/6/26 10:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 判断矩阵是否是一个X矩阵 {
    public boolean checkXMatrix(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        for(int q = 0; q < grid.length; q++) {
            set.add(i * grid[0].length + j);
            i++;
            j++;
        }
        i = 0;
        j = grid[0].length - 1;
        for(int q = 0; q < grid.length; q++) {
            set.add(i * grid[0].length + j);
            i++;
            j--;
        }

        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                int v = i * grid.length + j;
                if(set.contains(v) && grid[i][j] == 0) {
                    return false;
                }
                if(!set.contains(v) && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
