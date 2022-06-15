package com.company.array;

import com.company.util.ArrayUtils;

/**
 * @Classname 对角线遍历
 * @Date 2022/6/14 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 对角线遍历 {
    public static void main(String[] args) {
        对角线遍历 s = new 对角线遍历();
        ArrayUtils.print(s.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int x = 0;
        int y = 0;

        int index = 0;
        while (index < res.length) {
            while (index < res.length && x >= 0 && y < mat[0].length) {
                res[index ++] = mat[x][y];
                x--;
                y++;
            }
            x++;
            y--;
            if(y + 1 < mat[0].length) {
                y++;
            }else {
                x++;
            }
            while (index < res.length && x < mat.length && y >= 0) {
                res[index ++] = mat[x][y];
                x++;
                y--;
            }
            x--;
            y++;
            if(x + 1 >= mat.length) {
                y++;
            }else if(y - 1 < 0) {
                x++;
            }
        }
        return res;
    }
}
