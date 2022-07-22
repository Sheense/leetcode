package sheen.leetcode.array;

/**
 * @Classname 将一维数组转变成二维数组
 * @Date 2022/1/1 1:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 将一维数组转变成二维数组 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[][]{};
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                res[i][j] = original[i * n + j];
            }
        }
        return res;
    }
}
