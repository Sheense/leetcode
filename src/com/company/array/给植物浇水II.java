package com.company.array;

/**
 * @Classname 给植物浇水II
 * @Date 2021/12/12 10:55 上午
 * @Created by sheen
 * @Description TODO
 */
public class 给植物浇水II {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0;
        int right = plants.length - 1;
        int hasA = capacityA;
        int hasB = capacityB;
        int res = 0;
        while (left < right) {
            if(plants[left] > hasA) {
                hasA = capacityA;
                res++;
            }
            if(plants[right] > hasB) {
                hasB = capacityB;
                res++;
            }
            hasA -= plants[left++];
            hasB -= plants[right--];
        }
        if(left == right) {
            res += Math.max(hasA, hasB) >= plants[left] ? 0 : 1;
        }
        return res;
    }
}
