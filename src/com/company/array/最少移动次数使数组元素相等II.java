package com.company.array;

import java.util.*;

/**
 * @Classname 最少移动次数使数组元素相等II
 * @Date 2022/5/19 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最少移动次数使数组元素相等II {
    public int minMoves2(int[] nums) {
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                left[i] = nums[i];
                right[nums.length - i - 1] = nums[nums.length - i - 1];
            }else {
                left[i] = nums[i] + left[i-1];
                right[nums.length - i - 1] = right[nums.length - i] + nums[nums.length - i - 1];
            }
        }

        Map<Integer, int[]> map = new HashMap<>();
        int index = 0;
        while (index < nums.length) {
            int j = index;
            while (j < nums.length && nums[j] == nums[index]) {
                index++;
            }

            map.put(nums[index], new int[]{index, j - 1});
            index = j;
        }

        long res = Long.MAX_VALUE;
        List<Integer> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++) {
            int[] arr = map.get(list.get(i));
            int l = arr[0];
            int r = arr[1];
            long v = 0;
            if(l > 0) {
                v += (long)l * list.get(i) - left[l - 1];
            }

            if(r < nums.length - 1) {
                v += right[r + 1] - (long)(nums.length - r - 1) * list.get(i);
            }
            res = Math.min(res, v);
        }

        return (int)res;
    }
}
