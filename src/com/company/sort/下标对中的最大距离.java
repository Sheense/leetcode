package com.company.sort;

import java.util.Arrays;

public class 下标对中的最大距离 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int[][] arr1 = new int[nums1.length][2];
        int[][] arr2 = new int[nums2.length][2];
        for(int i=0;i<nums1.length;i++) {
            arr1[i] = new int[]{nums1[i], i};
        }
        for(int i=0;i<nums2.length;i++) {
            arr2[i] = new int[]{nums2[i], i};
        }
        Arrays.sort(arr1, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(arr2, (o1, o2) -> o1[0] - o2[0]);
        for(int i=1;i<arr1.length;i++) {
            arr1[i][1] = Math.min(arr1[i][1], arr1[i-1][1]);
        }
        int i = 0;
        int j = 0;
        int max = 0;
        while (j<arr2.length) {
            while (i<arr1.length && arr1[i][0]<=arr2[j][0]) {
                i++;
            }
            if(i == arr1.length || arr1[i][0] > arr2[j][0]) {
                if(i == 0) {
                    j++;
                    continue;
                }
                i--;
            }
            max = Math.max(max, arr2[j][1] - arr1[i][1]);
            j++;
        }
        return max;
    }
}
