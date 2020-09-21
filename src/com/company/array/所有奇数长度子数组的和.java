package com.company.array;

public class 所有奇数长度子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            int item = arr[i];
            res += item;
            for(int j = i+2;j<arr.length;j+=2) {
                item += (arr[j]+arr[j-1]);
                res += item;
            }
        }
        return res;
    }
}
