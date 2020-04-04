package com.company.sort;

import java.util.Arrays;


public class 找出数组中的幸运数 {
    public static void main(String[] args) {
        找出数组中的幸运数 s = new 找出数组中的幸运数();
        System.out.println(s.findLucky(new int[]{1,2,2,3,3,3}));
    }
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int max = -1;
        int i = 0;
        while(i<arr.length) {
            int index = i;
            while(i<arr.length&&arr[i]==arr[index]) i++;
            if(i-index==arr[index]) max = arr[index];
        }
        return max;
    }
}
