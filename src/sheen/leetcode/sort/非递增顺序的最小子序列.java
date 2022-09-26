package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 非递增顺序的最小子序列
 * @Date 2022/8/4 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int all = 0;
        for(int i = 0; i < nums.length; i++) all += nums[i];
        int now = 0;
        int i = nums.length - 1;
        List<Integer> res = new ArrayList<>();
        while (now <= all - now) {
            res.add(nums[i]);
            now += nums[i--];
        }

        return res;
    }
}
