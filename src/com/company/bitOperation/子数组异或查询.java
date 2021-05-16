package com.company.bitOperation;

public class 子数组异或查询 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for(int i=1;i<arr.length;i++) {
            arr[i] ^= arr[i-1];
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if(left - 1 < 0) {
                res[i] = arr[right];
            } else {
                res[i] = arr[right] ^ arr[left-1];
            }
        }
        return res;
    }
}
