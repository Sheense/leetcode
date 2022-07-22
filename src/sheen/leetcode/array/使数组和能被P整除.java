package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class 使数组和能被P整除 {
    public static void main(String[] args) {
        使数组和能被P整除 s = new 使数组和能被P整除();
        System.out.println(s.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
    }
    public int minSubarray(int[] nums, int p) {
        int [] pre = new int[nums.length];
        int [] last = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            if(i==nums.length-1) last[i] = nums[i]%p;
            else {
                last[i] = (nums[i]+last[i+1])%p;
            }
            if(last[i]==0) {
                min = Math.min(min, i);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(i==0) pre[i] = nums[i]%p;
            else pre[i] = (nums[i] + pre[i-1])%p;
            map.put(pre[i], i);
            if(pre[i]==0) {
                min = Math.min(nums.length-1-i, min);
            }
            if(i+1<nums.length) {
                int yu = (p - last[i+1])%p;
                if(map.containsKey(yu)) {
                    min = Math.min(i-map.get(yu),min);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
