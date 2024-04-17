package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 不同的平均值数目
 * @Date 2023/5/5 3:40 下午
 * @Created by sheen
 * @Description TODO
 */
public class 不同的平均值数目 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        Set<Double> set = new HashSet<>();
        while (start < end) {
            double v = (double)(nums[start++] + nums[end--]) / 2;
            set.add(v);
        }
        return set.size();
    }
}
