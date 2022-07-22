package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 最高频元素的频数
 * @Date 2021/7/19 1:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最高频元素的频数 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            if(i == 0) {
                arr[i] = nums[i];
            }else {
                arr[i] = nums[i] + arr[i-1];
            }
        }
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = i;
            while (left <= right) {
                int mid = (left + right) / 2;
                int all = mid == 0 ? arr[i] : arr[i] - arr[mid-1];
                int count = i - mid + 1;
                if(count * nums[i] - all > k) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
