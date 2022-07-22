package sheen.leetcode.array;

public class 转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix[0].length;i++) {
            for(int j=0;j<matrix.length;j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
