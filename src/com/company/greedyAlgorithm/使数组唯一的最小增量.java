package com.company.greedyAlgorithm;

public class 使数组唯一的最小增量 {

    public static void main(String[] args) {
        使数组唯一的最小增量 s = new 使数组唯一的最小增量();
        System.out.println(s.minIncrementForUnique(new int[]{1,2,2}));
    }

    public int minIncrementForUnique(int[] A) {
        if(A==null||A.length==0) return 0;
        sort(A, 0, A.length - 1);
        int count = 0;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]>=A[i+1]) {
                count += A[i]-A[i+1]+1;
                A[i+1] += A[i]-A[i+1]+1 ;
            }
        }
        return count;
    }

    public void sort(int [] arr, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int key = arr[start];
        while(left<right) {
            while(left<right&&arr[right]>=key) right--;
            arr[left] = arr[right];
            while (left<right&&arr[left]<=key) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr, start, left-1);
        sort(arr, left+1, end);
    }

}
