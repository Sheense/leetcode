package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 数位和相等数对的最大和
 * @Date 2023/11/18 01:03
 * @Created by sheen
 * @Description TODO
 */
public class 数位和相等数对的最大和 {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int key = 0;
            while (v != 0) {
                key += v % 10;
                v /= 10;
            }
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(nums[i]);
        }
        int max = 0;
        for(List<Integer> list : map.values()) {
            Collections.sort(list);
            if(list.size() >= 2) {
                max = Math.max(max, list.get(list.size() - 1) + list.get(list.size() - 2));
            }
        }

        return max;
    }
}
