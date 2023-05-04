package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 和相等的子数组
 * @Date 2023/3/26 12:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class 和相等的子数组 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++) {
            int v = nums[i] + nums[i + 1];
            if(set.contains(v)) {
                return true;
            }
            set.add(v);
        }
        return false;
    }
}
