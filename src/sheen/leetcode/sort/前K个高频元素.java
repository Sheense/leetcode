package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 前K个高频元素 {
    public static void main(String[] args) {
        前K个高频元素 s = new 前K个高频元素();
        ArrayUtils.print(s.topKFrequent(new int[]{5,2,5,3,5,3,1,1,3},2));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        sort(0, list.size()-1,list, map);
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = list.get(i);
        }
        System.out.println(map);
        System.out.println(list);
        return res;
    }
    public void sort(int start, int end, List<Integer> list, Map<Integer,Integer> map) {
        if(start>=end) return;
        int value = list.get(start);
        int left = start;
        int right = end;
        while (left<right) {
            while(left<right&&map.get(value)>=map.get(list.get(right))) right--;
            list.set(left, list.get(right));
            while (left<right&&map.get(list.get(left))>=map.get(value)) left++;
            list.set(right, list.get(left));
        }
        list.set(left, value);
        sort(start, left-1, list, map);
        sort(left+1, end, list, map);
    }
}
