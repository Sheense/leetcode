package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 矩阵区域和
 * @Date 2023/5/5 3:56 下午
 * @Created by sheen
 * @Description TODO
 */
public class 矩阵区域和 {
    public static void main(String[] args) {
        矩阵区域和 s = new 矩阵区域和();
        ArrayUtils.print2(s.matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 2));
    }
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] pre = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(j == 0) {
                    pre[i][j] = mat[i][j];
                }else {
                    pre[i][j] = mat[i][j] + pre[i][j - 1];
                }
            }
        }
        int [][] res = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                res[i][j] = getValue(pre, i, j, k);
            }
        }

        return res;
    }

    public int getValue(int[][] pre, int i, int j, int k) {
        int res = 0;
        int startX = Math.max(i - k, 0);
        int endX = Math.min(i + k, pre.length - 1);
        int startY = Math.max(j - k, 0);
        int endY = Math.min(j + k, pre[0].length - 1);
        for(int x = startX; x <= endX; x++) {
            if(startY == 0) {
                res += pre[x][endY];
            }else {
                res += (pre[x][endY] - pre[x][startY - 1]);
            }
        }

        return res;
    }


}
