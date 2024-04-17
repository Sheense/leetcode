package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 根据给定数字划分数组
 * @Date 2023/5/6 5:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 根据给定数字划分数组 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                left.add(nums[i]);
            }else if(nums[i] == pivot) {
                eq.add(nums[i]);
            }else {
                right.add(nums[i]);
            }
        }

        int[] res = new int[nums.length];
        int index = 0;
        for(int v : left) {
            res[index++] = v;
        }

        for(int v : eq) {
            res[index++] = v;
        }

        for(int v : right) {
            res[index++] = v;
        }

        return res;
    }
}
