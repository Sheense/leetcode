package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 找到两个数组中的公共元素
 * @Date 2024/7/16 00:39
 * @Created by sheen
 * @Description TODO
 */
public class 找到两个数组中的公共元素 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int v : nums1) {
            set1.add(v);
        }

        int b = 0;
        for(int v : nums2) {
            set2.add(v);
            if(set1.contains(v)) b++;
        }

        int a = 0;
        for(int v : nums1) {
            if(set2.contains(v)) a++;
        }


        return new int[]{a, b};
    }
}
