package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 找出数组排序后的目标下标
 * @Date 2021/11/28 12:24 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组排序后的目标下标 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int index = 0;
        List<Integer> res = new ArrayList<>();
        while (index < nums.length) {
            while (index <  nums.length && nums[index] == target) {
                res.add(index);
                index++;
            }
            index++;
        }
        return res;
    }
}
