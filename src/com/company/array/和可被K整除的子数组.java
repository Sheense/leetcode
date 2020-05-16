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
        int [] map1 = new int [K];
        int [] map2 = new int [K];
        int add = 0;
        int res = 0;
        map1[0] = 1;
        for(int i=0;i<A.length;i++) {
            add += A[i];
            int yu = add%K;
            if(yu<0) {
                res += map2[-yu];
                res += map1[yu+K];
                map2[-yu]++;
            }else if(yu>0){
                res += map1[yu];
                res += map2[-(yu-K)];
                map1[yu]++;
            }else {
                res += map1[0];
                map1[0]++;
            }
        }
        return res;
    }
}
