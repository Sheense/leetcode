package com.company.array;

import java.util.Arrays;

public class 有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++) {
            A[i] = (int)Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }
}
