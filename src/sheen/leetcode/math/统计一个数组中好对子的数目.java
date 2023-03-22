package sheen.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 统计一个数组中好对子的数目
 * @Date 2023/1/17 4:50 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计一个数组中好对子的数目 {
    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {

            int rev = 0;
            int v = nums[i];
            while (v != 0) {
                rev *= 10;
                rev += v % 10;
                v /= 10;
            }
            map.put(nums[i] - rev, map.getOrDefault(nums[i] - rev, 0) + 1);
        }

        long res = 0;
        int mod = (int) Math.pow(10, 9) + 7;
        for(int count : map.values()) {
            res += (long)(count) * (count - 1) / 2;
            res %= mod;
        }

        return (int )res;
    }
}
