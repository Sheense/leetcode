package com.company.array;

public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length/2;j++) {
                int item = A[i][A[i].length - j - 1];
                A[i][A[i].length - j - 1] = A[i][j] == 0 ? 1 : 0;
                A[i][j] = item == 0 ? 1 : 0;
            }
            if(A[i].length%2==1) {
                A[i][A[i].length/2] = A[i][A[i].length/2] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
