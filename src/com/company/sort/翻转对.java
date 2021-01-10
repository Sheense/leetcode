package com.company.sort;

import com.company.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 翻转对 {
    public static void main(String[] args) {
        翻转对 s = new 翻转对();
        System.out.println(s.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
    public int reversePairs(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for(int i=0;i<n.length;i++) n[i] = nums[i];
        return sort(0, nums.length-1, n);
    }

    public int sort(int start, int end, Integer[] nums) {
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int a = sort(start, mid, nums);
        int b = sort(mid+1, end, nums);
        int res = 0;
        int s = start;
        for(int i = mid+1;i<=end;i++) {
            while(s<=mid&&(long)nums[s]>2*(long)nums[i]) {
                s++;
            }
            res += (s - start);
        }
        Arrays.sort(nums, start, end+1, new ComparatorImpl());
        return a+b+res;
    }

    static class ComparatorImpl<Integer> implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if ((int)o1 > (int)o2) return -1;
            if ((int)o1 < (int)o2) return 1;
            return 0;
        }
    }
}
