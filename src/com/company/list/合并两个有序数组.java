package com.company.list;

import com.company.util.ArrayUtils;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        合并两个有序数组 s = new 合并两个有序数组();
        int [] nums = new int[]{1,2,3};
        s.merge(nums, 3,new int[]{},0);
        ArrayUtils.print(nums);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==9) {
            for(int i=0;i<nums1.length;i++) {
                nums1[i] = nums2[i];
            }
        }
        int index = m-1;
        for(int i=0;i<n;i++) {
            for(int j = index; j>=0;j--) {
                if(nums1[j]<=nums2[i]) {
                    nums1[j+1] = nums2[i];
                    index++;
                    break;
                }else {
                    nums1[j+1] = nums1[j];
                    if(j==0) {
                        nums1[j] = nums2[i];
                        index++;
                    }
                }
            }
        }
    }
}
