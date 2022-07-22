package sheen.leetcode.window;

import java.util.HashSet;
import java.util.Set;

public class 删除子数组的最大得分 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int start = 0;
        int item = 0;
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                while(start<i&&nums[start]!=nums[i]) {
                    set.remove(nums[start]);
                    item -= nums[start];
                    start++;
                }
                start++;
            }else {
                item += nums[i];
                max = Math.max(item, max);
                set.add(nums[i]);
            }
        }
        return max;
    }
}
