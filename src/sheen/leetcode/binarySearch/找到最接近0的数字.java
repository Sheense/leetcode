package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 找到最接近0的数字
 * @Date 2022/4/16 10:54 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找到最接近0的数字 {
    public static void main(String[] args) {
        找到最接近0的数字 s = new 找到最接近0的数字();
        System.out.println(s.findClosestNumber(new int[]{-100, -100}));
    }
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= 0) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        if(left == nums.length) {
            return nums[right];
        }

        if(right == -1) {
            return nums[left];
        }

        if(nums[left] == 0) {
            return 0;
        }

        return Math.abs(nums[left] - 0) <= Math.abs(nums[right] - 0) ? nums[left] : nums[right];
    }
}
