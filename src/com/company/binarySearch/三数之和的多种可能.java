package com.company.binarySearch;

import java.util.Arrays;

public class 三数之和的多种可能 {
    public static void main(String[] args) {
        三数之和的多种可能 s = new 三数之和的多种可能();
        System.out.println(s.threeSumMulti(new int[]{0,0,0,0,0,0}, 0));
    }
    public int threeSumMulti(int[] arr, int target) {
        int[] A = new int[101];
        for(int i=0;i<arr.length;i++) A[arr[i]]++;
        long res = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i] == 0) continue;
            for(int j = i; j<A.length;j++) {
                if(A[j] > 0) {
                    int t = target - (i + j);
                    if(t < j) {
                        break;
                    }else {
                        if(t > 100) continue;
                        //三数为同一个数的情况
                        if(t == i && t == j) {
                            res += ((long)A[i] * (A[i] - 1) * (A[i] - 2)) / 6;
                        //三数，后两个为同一个的情况
                        }else if(t == j) {
                            res += ((long)A[j] * (A[j] - 1)) / 2 * A[i];;
                        //三数，前两个为同一个的情况
                        }else if(i == j) {
                            res += ((long)A[i] * (A[i] - 1) )/2 * A[t];
                        }else {
                            res += (long)A[i] * A[j] * A[t];
                        }
                    }
                }
            }
        }
        return (int)(res % (long) (Math.pow(10, 9) + 7));
    }




}
