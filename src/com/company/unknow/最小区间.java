package com.company.unknow;

import com.company.util.ArrayUtils;

import java.util.*;

public class 最小区间 {

    public static void main(String[] args) {
        最小区间 s = new 最小区间();
        List<List<Integer>> list = Arrays.asList(Arrays.asList(4,10,15,24,26), Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30));
        ArrayUtils.print(s.smallestRange(list));
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //存储全部数的列表索引
        for(int i=0;i<nums.size();i++) {
            for(int j=0;j<nums.get(i).size();j++) {
                List<Integer> list = map.computeIfAbsent(nums.get(i).get(j), x->new ArrayList<>());
                list.add(i);
            }
        }
        List<Integer> sort = new ArrayList<>(map.keySet());
        Collections.sort(sort);
        int left = 0;
        int right = 0;
        Map<Integer, Integer> indexNum = new HashMap<>();
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        while(right<sort.size()) {
            for(int i: map.get(sort.get(right))) {
                indexNum.put(i, indexNum.getOrDefault(i,0)+1);
            }
            while(check(indexNum, nums.size())) {
                if(sort.get(right)-sort.get(left)<min) {
                    min = sort.get(right)-sort.get(left);
                    res[0] = sort.get(left);
                    res[1] = sort.get(right);
                }
                for(int i: map.get(sort.get(left))) {
                    indexNum.put(i, indexNum.get(i)-1);
                }
                left++;
            }
            right++;
        }
        return res;
    }
    //indexNum的key存在且value！=0的key，存在num个时，表示包含
    public boolean check(Map<Integer, Integer> indexNum, int num) {
        for(int i=0;i<num;i++) {
            if(!indexNum.containsKey(i)||indexNum.get(i)==0) {
                return false;
            }
        }
        return true;
    }

}
