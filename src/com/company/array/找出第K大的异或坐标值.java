package com.company.array;

import java.util.Arrays;

public class 找出第K大的异或坐标值 {
    public int kthLargestValue(int[][] matrix, int k) {
        int[] arr = new int[matrix.length*matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            int [] r = new int[matrix[i].length];
            for(int j=0;j<matrix[i].length;j++) {
                if(i==0&&j==0) {
                    r[j] = matrix[i][j];
                    arr[i*matrix[0].length + j]= matrix[i][j];
                }else if(i==0) {
                    r[j] = r[j-1] ^ matrix[i][j];
                    arr[i*matrix[0].length + j] =  r[j] ;
                }else if(j==0) {
                    r[j] = matrix[i][j];
                    arr[i*matrix[0].length + j] = arr[(i-1)*matrix[0].length+j] ^ r[j];
                }else {
                    r[j] = r[j-1] ^ matrix[i][j];
                    arr[i*matrix[0].length + j] = arr[(i-1)*matrix[0].length+j] ^ r[j];
                }
            }
        }
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
}
