package com.company.array;

public class 按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] A) {
        int a[] = new int [A.length/2];
        int b[] = new int [A.length/2];
        int i = 0;
        int j = 0;
        for(int z=0;i<A.length;i++) {
            if(A[z]%2==0) a[i++] = A[z];
            if(A[z]%2==1) b[j++] = A[z];
        }
        i = 0;
        j = 0;
        for(int z=0;z<A.length;z++) {
            if(z%2==0) A[z] = a[i++];
            else A[z] = b[j++];
        }
        return A;
    }
}
