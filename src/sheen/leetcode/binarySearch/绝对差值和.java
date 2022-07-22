package sheen.leetcode.binarySearch;

import java.util.Arrays;

public class 绝对差值和 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] copy = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) copy[i] = nums1[i];
        Arrays.sort(copy);
        long sum = 0;
        for(int i=0;i<nums1.length;i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        long min = sum;
        for(int i=0;i<nums1.length;i++) {
            long item = sum - Math.abs(nums1[i] - nums2[i]);
            int target = binSearch(copy, nums2[i]);
            item += Math.abs(target - nums2[i]);
            min = Math.min(item, min);
        }
        return (int)(min % (Math.pow(10, 9) + 7));
    }

    public int binSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left<=right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return target;
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left<0 || left >= nums.length) return nums[right];
        if(right>=nums.length || right < 0) return nums[left];
        if(Math.abs(target - nums[left]) < Math.abs(target - nums[right])) return nums[left];
        return nums[right];
    }
}
