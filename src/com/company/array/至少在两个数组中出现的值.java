package com.company.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 至少在两个数组中出现的值
 * @Date 2021/10/10 2:12 下午
 * @Created by sheen
 * @Description TODO
 */
public class 至少在两个数组中出现的值 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> set1 = create(nums1);
        Set<Integer> set2 = create(nums2);
        Set<Integer> set3 = create(nums3);

        Set<Integer> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        set.addAll(set3);
        List<Integer> res = new ArrayList<>();
        for(int num : set) {
            int count = 0;
            if(set1.contains(num)) count ++;
            if(set2.contains(num)) count++;
            if(set3.contains(num)) count++;
            if(count >= 2) {
                res.add(num);
            }
        }
        return res;
    }

    public Set<Integer> create(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return set;
    }
}
