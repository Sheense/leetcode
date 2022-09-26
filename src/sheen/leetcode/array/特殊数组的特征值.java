package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 特殊数组的特征值
 * @Date 2022/9/12 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 特殊数组的特征值 {
    public static void main(String[] args) {
        特殊数组的特征值 s = new 特殊数组的特征值();
        s.specialArray(new int[]{3,6,7,7,0});
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i <= nums.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] >= i) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            if(nums.length - left == i) {
                return i;
            }

        }
        return -1;
    }
}
