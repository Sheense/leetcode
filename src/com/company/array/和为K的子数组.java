package com.company.array;

import java.util.HashMap;
import java.util.Map;
//前缀和
public class 和为K的子数组 {

    public static void main(String[] args) {
        和为K的子数组 s = new 和为K的子数组();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int add = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            add+=nums[i];
            if(map.containsKey(add-k)) {
                res += map.get(add-k);
            }
            if(map.containsKey(add)) {
                map.put(add, map.get(add)+1);
            }else{
                map.put(add,1);
            }
        }
        return res;
    }
}
