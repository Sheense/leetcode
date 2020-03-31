package com.company.binarySearch;

public class 搜索二维矩阵 {

    public static void main(String[] args) {
        搜索二维矩阵 s = new 搜索二维矩阵();
        int [][] matrix = {
              {1,3,5,  7},
              {10, 11, 16, 20},
              {23, 30, 34, 50}
        };

        System.out.println(s.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int start = 0;
        int end = matrix.length*matrix[0].length -1;
        while(start<=end) {
            int mid = (start+end)/2;
            int i = mid/matrix[0].length;
            int j = mid%matrix[0].length;
            if(matrix[i][j] == target) return true;
            if(matrix[i][j]> target) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}
