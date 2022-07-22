package sheen.leetcode.array;

import java.util.Arrays;

public class 判断能否形成等差数列 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i=1;i<arr.length-1;i++) {
            if(arr[i+1]-arr[i]!=diff) return false;
        }
        return true;
    }
}
