package sheen.leetcode.array;

public class 搜索二维矩阵II {

    public static void main(String[] args) {
        搜索二维矩阵II s = new 搜索二维矩阵II();
        int[][] arr = {
                            {1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}

        };

        System.out.println(s.searchMatrix(arr, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = 0;
        int j = matrix[i].length-1;
        while(true) {
            while(j>=0&&matrix[i][j]>target) {
                j--;
            }
            if(j<0) return false;
            if(matrix[i][j]==target) return true;
            i++;
            if(i==matrix.length) return false;
        }
    }
}
