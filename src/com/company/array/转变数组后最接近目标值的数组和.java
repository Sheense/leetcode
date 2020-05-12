package com.company.array;

import java.util.Arrays;

public class 转变数组后最接近目标值的数组和 {

    public static void main(String[] args) {
        转变数组后最接近目标值的数组和 s = new 转变数组后最接近目标值的数组和();
        System.out.println(s.findBestValue(new int[]{2,3,5},10));
    }
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        int res = 0;
        int start = target/arr.length;
        while(start>arr[j]) {
            sum+=arr[j];
            j++;
        }
        for(int i=start;i<=arr[arr.length-1];i++) {
            if(arr[j]==i) {
                sum+=arr[j];
                j++;
            }
            int all = sum + (arr.length-j)*i;
            int item = Math.abs(all-target);
            if(item<gap) {
                gap = item;
                res = i;
            }
        }
        return res;
    }
}
