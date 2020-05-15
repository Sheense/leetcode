package com.company.array;

import com.company.util.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 和可被K整除的子数组 {

    public static void main(String[] args) {
        和可被K整除的子数组 s = new 和可被K整除的子数组();
        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int add = 0;
        int res = 0;
        map.put(0,1);
        for(int i=0;i<A.length;i++) {
            add += A[i];
            A[i] = add;
            if(add%K==0) {
                res += map.get(0);
            }else {
                int yu = add %K;
                res += map.getOrDefault(add-yu,0);
                res += map.getOrDefault(add+K-yu,0);
            }

            if(map.containsKey(add)) {
                map.put(add, map.get(add)+1);
            }else {
                map.put(add, 1);
            }
        }
        return res;
    }
}
