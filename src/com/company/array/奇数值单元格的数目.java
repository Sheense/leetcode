package com.company.array;

/**
 * @Classname 奇数值单元格的数目
 * @Date 2022/7/12 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];
        for(int i = 0; i < indices.length; i++) {
            int r = indices[i][0];
            for(int j = 0; j < res[0].length; j++) {
                res[r][j] += 1;
            }
            int c = indices[i][1];
            for(int j = 0; j < res.length; j++) {
                res[j][c] += 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i].length; j++) {
                if(res[i][j] % 2 == 1) ans++;
            }
        }

        return ans;
    }
}
