package com.company.math;

public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        寻找两个有序数组的中位数 s = new 寻找两个有序数组的中位数();
        int [] nums1 = new int []{1};
        int [] nums2 = new int []{2,3,4,5,6};
        double res = s.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0) {
            return nums2.length%2==0 ? ((double)nums2[(nums2.length)/2] + nums2[(nums2.length)/2-1])/2:nums2[nums2.length/2];
        }
        if(nums2==null || nums2.length==0) {
            return nums1.length%2==0 ? ((double)nums1[(nums1.length)/2] + nums1[(nums1.length)/2-1])/2:nums1[nums1.length/2];
        }
        int len = nums1.length+nums2.length;
        if(len%2 == 0) {
            return (findK(nums1,nums2,len/2)+findK(nums1,nums2,len/2+1))/2;
        } else {
            return findK(nums1,nums2,len/2+1);
        }
    }

    public double findK(int nums1[],int nums2[],int k) {
        int start1 = 0;
        int start2 = 0;
        while(k!=1) {
            int item = k/2;
            if(start1==nums1.length||start2==nums2.length) {
                break;
            }
            int end1 = item+start1-1>nums1.length-1?nums1.length-1:item+start1-1;
            int end2 = item+start2-1>nums2.length-1?nums2.length-1:item+start2-1;
            if(nums1[end1]>nums2[end2]) {
                k -= (end2-start2+1);
                start2 = end2 + 1;

            } else {
                k -= (end1-start1+1);
                start1 = end1 + 1;
            }
        }
        if(start1==nums1.length) {
            start2 += k-1;
            return nums2[start2];
        }
        if(start2==nums2.length){
            start1 += k-1;
            return nums1[start1];
        }
        return nums1[start1]>nums2[start2]? nums2[start2] : nums1[start1];
    }
}
