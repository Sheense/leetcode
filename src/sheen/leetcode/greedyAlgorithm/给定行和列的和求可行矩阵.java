package sheen.leetcode.greedyAlgorithm;

import sheen.leetcode.util.ArrayUtils;

/**
 * @Classname 给定行和列的和求可行矩阵
 * @Date 2023/3/14 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 给定行和列的和求可行矩阵 {
    public static void main(String[] args) {
        给定行和列的和求可行矩阵 s = new 给定行和列的和求可行矩阵();
        ArrayUtils.print2(s.restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8}));
    }
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++) {
            int val = rowSum[i];
            for(int j = 0; j < colSum.length; j++) {
                if(val == 0) {
                    break;
                }
                if(colSum[j] == 0) {
                    continue;
                }
                int minus = Math.min(colSum[j], val);
                res[i][j] = minus;
                val -= minus;
                colSum[j] -= minus;
            }
        }
        return res;
    }
}
