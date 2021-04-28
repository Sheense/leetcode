package com.company.binarySearch;

import java.util.Arrays;

public class 最小差 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++) {
            int target = a[i];
            int start = 0;
            int end = b.length - 1;
            while (start<=end) {
                int mid = (start + end) / 2;
                if(b[mid] == target) return 0;
                else if (b[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if(start < b.length) {
                min = Math.min(min, Math.abs((long)b[start] - a[i]));
            }
            if(end >= 0) {
                min = Math.min(min, Math.abs((long)b[end] - a[i]));
            }
        }
        return (int)min;
    }
}
