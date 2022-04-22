package com.company.array;

import java.util.*;

/**
 * @Classname 找出两数组的不同
 * @Date 2022/3/27 10:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出两数组的不同 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(i - 1 >= 0 && nums1[i] == nums1[i-1]) continue;
            if(!set2.contains(nums1[i])) {
                list1.add(nums1[i]);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(i - 1 >= 0 && nums2[i] == nums2[i-1]) continue;

            if(!set1.contains(nums2[i])) {
                list2.add(nums2[i]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;

    }
}
