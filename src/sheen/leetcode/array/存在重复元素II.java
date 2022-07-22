package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(i);
        }
        Collections.sort(list, (i, j) -> {
            if(nums[i] == nums[j]) {
                return i - j;
            }
            return nums[i] - nums[j];
        });
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            while (right < nums.length && nums[list.get(left)] == nums[list.get(right)]) {
                if(right != left && Math.abs(list.get(right - 1) - list.get(right)) <= k) {
                    return true;
                }
                right++;
            }
            left = right;
        }
        return false;
    }
}
