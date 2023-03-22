package sheen.leetcode.GeminiNeedle;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Classname 区间子数组个数
 * @Date 2022/11/24 12:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 区间子数组个数 {
    public static void main(String[] args) {
        区间子数组个数 s  = new 区间子数组个数();
        System.out.println(s.numSubarrayBoundedMax(new int[]{2,1,4,3}, 2 ,3));
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int one = -1;
        int two = -1;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= left && nums[i] <= right) {
                one = i;
            }
            if(nums[i] > right) {
                one = -1;
                two = i;
            }

            if(one != -1) {
                res += one - two;
            }
        }

        return res;
    }
}
