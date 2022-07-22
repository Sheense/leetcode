package sheen.leetcode.array;

public class 托普利茨矩阵 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int index = matrix.length - 1;
        while(index>=0) {
            int i = index;
            int j = 0;
            int item = matrix[i][j];
            while(i+1<matrix.length&&j+1<matrix[i+1].length) {
                i++;
                j++;
                if(matrix[i][j]!=item) {
                    return false;
                }
            }
            index--;
        }
        index = 1;
        while(index<matrix[0].length) {
            int i = 0;
            int j = index;
            int item = matrix[i][j];
            while(i+1<matrix.length&&j+1<matrix[0].length) {
                i++;
                j++;
                if(matrix[i][j]!=item) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }
}
