package com.company.array;

import java.util.*;

/**
 * @Classname 含最多K个可整除元素的子数组
 * @Date 2022/5/1 10:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 含最多K个可整除元素的子数组 {
    public static void main(String[] args) {
        含最多K个可整除元素的子数组 s = new 含最多K个可整除元素的子数组();
        System.out.println(s.countDistinct(new int[]{14,19,9}, 1, 11));
    }
    public int countDistinct(int[] nums, int k, int p) {
        String n = "";
        Set<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            String str = "";
            for(int j = i; j < nums.length; j++) {
                if(nums[i] % p == 0) {
                    count ++;
                }
                if(count <= k) {
                    str += nums[i] + "#";
                    set.add(str);
                }else {
                    break;
                }
            }
        }

        return set.size();
    }



}
