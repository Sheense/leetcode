package com.company.binarySearch;

import com.company.util.ArrayUtils;

import java.util.Arrays;

public class 交换和 {
    public static void main(String[] args) {
        交换和 s = new 交换和();
    }
    public int[] findSwapValues(int[] array1, int[] array2) {
        long all1 = 0;
        long all2 = 0;
        int i = 0;
        int j = 0;
        while (i<array1.length || j<array2.length) {
            if(i<array1.length) {
                all1+= array1[i++];
            }
            if(j<array2.length) {
                all2 += array2[j++];
            }
        }
        int diff = (int)Math.abs(all1 - all2);
        if ((diff&1) == 1) return new int[]{};
        if (array1.length >= array2.length) {
            Arrays.sort(array1);
            for(int z = 0; z<array2.length;z++) {
                int target = (int)(all1 - all2) /2 + array2[z];
                if (search(array1, target) != -1) {
                    return new int[]{target, array2[z]};
                }
            }
        }else {
            Arrays.sort(array2);
            for(int z = 0; z<array1.length;z++) {
                int target = (int)(all2 - all1) /2 + array2[z];
                if (search(array2, target) != -1) {
                    return new int[]{array1[z], target};
                }
            }
        }
        return new int[]{};
    }

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] == target) return mid;
            else if(arr[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
