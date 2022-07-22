package sheen.leetcode.tree;

import java.util.Arrays;

public class 区间和的个数 {
    public static void main(String[] args) {
        区间和的个数 s = new 区间和的个数();
        System.out.println(s.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -2, 2));
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] pre = new long[nums.length+1];
        for(int i=0;i<pre.length;i++) {
            if(i==0) pre[i] = 0;
            else {
                pre[i] = pre[i-1] + nums[i-1];
            }
        }
        return sort(pre, 0,pre.length-1,lower, upper);
    }

    public int sort(long[] pre, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        int a = sort(pre, start, (start+end)/2, lower,upper);
        int b = sort(pre,(start+end)/2+1, end, lower, upper);
        int res = a+b;
        for (int i = start;i<=(start+end)/2;i++) {
            int l = (start+end)/2+1;
            while(l<=end&&pre[l]<pre[i]+lower) l++;
            if(l>end) break;
            int r = l;
            while(r<=end&&pre[r]<=pre[i]+upper)r++;
            res += r-l;
        }
        Arrays.sort(pre, start, end+1);
        return res;
    }
}
