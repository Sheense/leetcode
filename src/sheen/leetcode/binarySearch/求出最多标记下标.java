package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 求出最多标记下标
 * @Date 2024/9/12 00:25
 * @Created by sheen
 * @Description TODO
 */
public class 求出最多标记下标 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
       int left = 0;
       int right = nums.length / 2;
       while (left <= right) {
           int mid = (left + right) / 2;
           if(check(nums, mid)) {
               left = mid + 1;
           }else {
               right = mid - 1;
           }
       }
       return right * 2;
    }

    public boolean check(int[] nums, int m) {
        for(int i = 0; i < m; i++) {
            if(2 * nums[i] > nums[nums.length - m + i]) {
                return false;
            }
        }
        return true;
    }
}
