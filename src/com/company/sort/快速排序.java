package com.company.sort;

public class 快速排序 {
    public void sort(int [] arr, int start, int end) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        int key = arr[start];
        while(left<right) {
            while(left<right&&arr[right]>=key)  right--;
            arr[left] = arr[right];
            while(left<right&&arr[left]<=key) left--;
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr, start,left-1);
        sort(arr, left+1, end);
    }
}
