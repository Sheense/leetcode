package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 统计得分小于K的子数组数目
 * @Date 2023/5/6 12:31 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计得分小于K的子数组数目 {
    public static void main(String[] args) {
        统计得分小于K的子数组数目 s = new 统计得分小于K的子数组数目();
        System.out.println(s.countSubarrays(new int[]{2,1,4,3,5}, 10));
    }
    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        long sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && (right - left + 1) * sum >= k) {
                sum -= nums[left];
                left++;
            }
            res += right - left + 1;
        }

        return res;
    }
}
