package com.company.array;

public class 合并排序的数组 {
    public static void main(String[] args) {
        合并排序的数组 s = new 合并排序的数组();
        s.merge(new int[]{4,0,0,0,0,0}, 1, new int[]{1,2,3,5,6}, 5);
    }
    public void merge(int[] A, int m, int[] B, int n) {
        if(m == 0)  {
            for(int i=0;i<A.length;i++) {
                A[i] = B[i];
            }
            return ;
        }
        for(int i = m-1;i>=0;i--) {
            A[i+n] = A[i];
        }
        int index = 0;
        int i = A.length - m;
        int j = 0;
        while (i<(m+n)&&j<n) {
            if(A[i]>=B[j]) {
                A[index++] = B[j];
                j++;
            }else {
                A[index++] = A[i];
                i++;
            }
        }
        while (j<n) {
            A[index++] = B[j++];
        }
    }
}
