package com.company.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 递增子序列 {
    public static void main(String[] args) {
        递增子序列 s = new 递增子序列();
        System.out.println(s.findSubsequences(new int[]{4, 6, 7, 7}));
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        recall(map, 0, new ArrayList<>(), nums);
        List<List<Integer>> res = new ArrayList<>();
        for(List<List<Integer>> elem:map.values()) {
            res.addAll(elem);
        }
        return res;
    }
    public void recall(Map<Integer, List<List<Integer>>> map, int start, List<Integer> now, int[] nums) {
        if(start>=nums.length) return;
        for(int i=start;i<nums.length;i++) {
            if(now.size()==0||now.get(now.size()-1)<=nums[i]){
                if(i==start||(i>start&&nums[i]!=nums[i-1])) {
                    List<Integer> temp = new ArrayList<>(now);
                    temp.add(nums[i]);
                    if(temp.size()>1) {
                        if(!map.containsKey(temp.size())) {
                            map.computeIfAbsent(temp.size(), x -> new ArrayList<>()).add(temp);
                        }else {
                            List<List<Integer>> list = map.get(temp.size());
                            boolean flag = true;
                            for(int j=0;j<list.size();j++) {
                                boolean flag1 = true;
                                int index = 0;
                                while(index<list.get(j).size()) {
                                    if(temp.get(index)!=list.get(j).get(index)) {
                                        flag1 = false;
                                        break;
                                    }
                                    index++;
                                }
                                if(flag1) flag = false;
                            }
                            if(flag) list.add(temp);
                        }
                    }
                    recall(map, i+1,temp, nums);
                }
            }
         }
    }
}
