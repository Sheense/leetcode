package sheen.leetcode.array;

public class 二维区域和检索_矩阵不可变 {
    class NumMatrix {
        private int[][] arr;
        public NumMatrix(int[][] matrix) {
            if(matrix.length != 0 && matrix[0].length != 0) {
                arr = new int[matrix.length][matrix[0].length+1];
                for(int i=0;i<matrix.length;i++) {
                    for(int j=1;j<matrix[i].length+1;j++) {
                        arr[i][j] = arr[i][j-1] + matrix[i][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(arr == null) return 0;
            int res = 0;
            for(int i = row1;i<=row2;i++) {
                res += (arr[i][col2+1] - arr[i][col1]);
            }
            return res;
        }
    }
}
