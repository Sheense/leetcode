package sheen.leetcode.array;

import java.util.TreeSet;

/**
 * @Classname 从两个数字数组里生成最小数字
 * @Date 2023/9/5 00:17
 * @Created by sheen
 * @Description TODO
 */
public class 从两个数字数组里生成最小数字 {
    public int minNumber(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        for(int i :  set1) {
            if(set2.contains(i)) {
                return i;
            }
        }

        int a = set1.first();
        int b = set2.first();
        if(a * 10 + b > b * 10 + a) {
            return b * 10 + a;
        }
        return a * 10 + b;
    }

}
