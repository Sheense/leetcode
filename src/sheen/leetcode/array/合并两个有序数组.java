package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        合并两个有序数组 s = new 合并两个有序数组();
        int [] nums = new int[]{4,0,0,0,0,0};
        s.merge(nums, 1,new int[]{1,2,3,5,6},5);
        ArrayUtils.print(nums);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        for(int i=m-1;i>=0;i--) {
            nums1[i+n] = nums1[i];
        }
        int i = n;
        int j = 0;
        int index = 0;
        while (i<nums1.length&&j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                nums1[index++] = nums1[i];
                i++;
            }else {
                nums1[index++] = nums2[j];
                j++;
            }
        }
        while (j<nums2.length) {
            nums1[index++] = nums2[j++];
        }
    }
}
