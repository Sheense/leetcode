package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 袋子里最少数目的球
 * @Date 2022/12/20 12:52 上午
 * @Created by sheen
 * @Description TODO
 */
public class 袋子里最少数目的球 {
    public static void main(String[] args) {
        袋子里最少数目的球 s = new 袋子里最少数目的球();
        System.out.println(s.minimumSize(new int[]{1}, 1));
    }
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length - 1];
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(canMin(maxOperations, nums, mid)) {
               right = mid - 1;
            }else {
               left = mid + 1;
            }
        }

        return left;
    }

    public boolean canMin(int maxOperations, int[] nums, int target) {
        int start = searchIndex(nums, target);
        while (start < nums.length && maxOperations > 0) {
            int item = nums[start ++];
            int count = item / target - (item % target == 0 ? 1 : 0);
            maxOperations -= count;
        }

        return maxOperations >= 0 && start == nums.length;
    }

    public int searchIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
}
