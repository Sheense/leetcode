package com.company.recall;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II {
    public static void main(String[] args) {
        子集II s = new 子集II();
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        recall(res, nums, 0);
        return res;
    }

    public void recall(List<List<Integer>> res, int[] nums, int index) {
        if(index>=nums.length) return ;
        int value = nums[index];
        List<Integer> list = new ArrayList<>();
        int size = res.size();
        while(index<nums.length&&value==nums[index]) {
            list.add(nums[index]);
            for(int z=0;z<size;z++) {
                List<Integer> item = res.get(z);
                List<Integer> l = new ArrayList<>(item);
                l.addAll(list);
                res.add(l);
            }
            index++;
        }
        recall(res, nums, index);
    }

}
