package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 找出第K小的数对距离
 * @Date 2022/6/15 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出第K小的数对距离 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int j = 0; j < nums.length; j++) {
                cnt += searchCnt(nums, j, nums[j] - mid);
            }
            if(cnt >= k) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int searchCnt(int[] nums, int end, int target) {
        int left = 0;
        int right = end - 1;
        if(right < 0) {
            return 0;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return end - left;
    }
}
