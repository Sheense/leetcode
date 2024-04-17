package sheen.leetcode.bitOperation;

import java.util.Arrays;

/**
 * @Classname 采购方案
 * @Date 2023/5/5 10:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 采购方案 {
    public int purchasePlans(int[] nums, int target) {
        int res = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            int index = find(nums, 0, i - 1, target - nums[i]);
            res += index + 1;
            res %= mod;
        }
        return res;
    }
    public int find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}
