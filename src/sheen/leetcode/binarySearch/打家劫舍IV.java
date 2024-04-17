package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 打家劫舍IV
 * @Date 2023/9/19 00:55
 * @Created by sheen
 * @Description TODO
 */
public class 打家劫舍IV {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        while (left <= right) {
            int count = 0;
            boolean visit = false;
            int mid = (left + right) / 2;
            for(int num : nums) {
                if(num <= mid && !visit) {
                    count++;
                    visit = true;
                }else {
                    visit = false;
                }
            }

            if(count >= k) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
