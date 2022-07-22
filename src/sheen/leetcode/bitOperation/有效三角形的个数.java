package sheen.leetcode.bitOperation;

import java.util.Arrays;

/**
 * @Classname 有效三角形的个数
 * @Date 2021/8/4 1:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效三角形的个数 {
    public static void main(String[] args) {
        有效三角形的个数 s = new 有效三角形的个数();
        System.out.println(s.triangleNumber(new int[]{2,2,3,4}));
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length -2; i++) {
            for(int j = i+1; j < nums.length -1; j++) {
                int rightValue = nums[j] + nums[i];
                int leftValue = Math.abs(nums[j] - nums[i]);
                int right = findRight(j+1, nums.length-1, nums, rightValue);
                int left = findLeft(j+1, nums.length-1, nums, leftValue);
                if(right - left + 1 > 0) {
                    res += (right - left) + 1;
                }
            }
        }
        return res;
    }

    public int findRight(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end;
    }

    public int findLeft(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] <= target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }


}
