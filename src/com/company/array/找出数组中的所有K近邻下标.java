package com.company.array;

import java.util.*;

/**
 * @Classname 找出数组中的所有K近邻下标
 * @Date 2022/3/13 3:47 下午
 * @Created by sheen
 * @Description TODO
 */
public class 找出数组中的所有K近邻下标 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                res.add(i);
                int index = i - 1;
                while (index >= 0 && Math.abs(index - i) <= k) {
                    res.add(index);
                    index--;
                }
                index = i + 1;
                while (index < nums.length && Math.abs(index - i) <= k) {
                    res.add(index);
                    index++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>(res);
        ans.sort((x, y) -> x - y);
        return ans;
    }
}
