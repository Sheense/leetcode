package com.company.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++) {
            set2.add(nums2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int n:set1) {
            if(set2.contains(n)) list.add(n);
        }
        int [] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
