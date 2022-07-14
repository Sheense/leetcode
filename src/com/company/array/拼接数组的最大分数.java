package com.company.array;

/**
 * @Classname 拼接数组的最大分数
 * @Date 2022/6/26 11:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 拼接数组的最大分数 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int v1 = 0;
        int v2 = 0;
        int[] arr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            v1 += nums1[i];
            v2 += nums2[i];
            arr[i] = nums1[i] - nums2[i];
        }

        int res = Math.max(v1, v2);

        int min = 0;
        int max = 0;
        int q = 0;
        int l = 0;
        for(int i = 0; i < arr.length; i++) {
            q += arr[i];
            min = Math.min(q, min);
            if(q > 0) {
                q = 0;
            }

            l += arr[i];
            max = Math.max(l, max);
            if(l < 0) {
                l = 0;
            }
        }

        return Math.max(res, Math.max(v1 + Math.abs(min), v2 + max));
    }
}
