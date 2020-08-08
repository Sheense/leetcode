package com.company.array;

public class 第k个缺失的正整数 {
    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int res = 1;
        while(k>0) {
            if(index<arr.length&&res==arr[index]){
                index++;
            }else {
                k--;
            }
            res++;
        }
        return res-1;
    }
}
