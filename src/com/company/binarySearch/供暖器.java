package com.company.binarySearch;

import java.util.Arrays;

/**
 * @Classname 供暖器
 * @Date 2021/12/20 12:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 供暖器 {
    public static void main(String[] args) {
        供暖器 s = new 供暖器();
        System.out.println(s.findRadius(new int[]{1}, new int[]{1, 2, 3, 4}));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = heaters[0];
        int max = heaters[0];
        for(int i = 0; i < houses.length; i++) {
            min = Math.min(houses[i], min);
            max = Math.max(houses[i], max);
        }
        for(int i = 0; i < heaters.length; i++) {
            min = Math.min(heaters[i], min);
            max = Math.max(heaters[i], max);
        }
        long left = 0;
        long right = max - min;
        while (left <= right) {
            long mid = (left + right) / 2;
            if(isFlag(houses, heaters, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public boolean isFlag(int[] houses, int[] heaters, long round) {
        int index = 0;
        for(int i = 0; i < heaters.length; i++) {
            long left = heaters[i] - round;
            long right = heaters[i] + round;
            if(houses[index] < left) {
                return false;
            }
            while (index < houses.length && houses[index] >= left && houses[index] <= right) {
                index++;
            }
            if(index == houses.length) {
                return true;
            }
        }
        return false;
    }
}
