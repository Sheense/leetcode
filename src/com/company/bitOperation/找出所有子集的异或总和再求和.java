package com.company.bitOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找出所有子集的异或总和再求和 {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> res = subsets(nums);
        int ans = 0;
        for(int i=0;i<res.size();i++) {
            if(res.get(i).size() == 0) continue;
            int item = res.get(i).get(0);
            for(int j=1;j<res.get(i).size();j++) {
                item ^= res.get(i).get(j);
            }
            ans += item;
        }
        return ans;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recall(res, nums, 0);
        return res;
    }

    public void recall(List<List<Integer>> res, int[] nums, int index) {
        if(index>=nums.length) return ;
        List<Integer> list = new ArrayList<>();
        list.add(nums[index]);
        int size = res.size();
        for(int z=0;z<size;z++) {
            List<Integer> item = res.get(z);
            List<Integer> l = new ArrayList<>(item);
            l.addAll(list);
            res.add(l);
        }
        index++;
        recall(res, nums, index);
    }
}
