package com.company.binarySearch;

import com.company.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class 找两个和为目标值且不重叠的子数组 {

    public static void main(String[] args) {
        找两个和为目标值且不重叠的子数组 s = new 找两个和为目标值且不重叠的子数组();
        System.out.println(s.minSumOfLengths(new int[]{31,1,1,18,15,3,15,14},33));
    }
    public int minSumOfLengths(int[] arr, int target) {
        int[] dpRight = new int[arr.length];
        int[] dpLeft = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            dpRight[i] = Integer.MAX_VALUE;
            dpLeft[i] = Integer.MAX_VALUE;
        }
        Map<Integer, Integer> mapLeft = new HashMap<>();
        Map<Integer, Integer> mapRight = new HashMap<>();
        mapLeft.put(0, -1);
        mapRight.put(0, arr.length);
        int left = 0;
        for(int i=0;i<arr.length;i++) {
            left += arr[i];
            mapLeft.put(left, i);
            if(arr[i]>target) {
                dpLeft[i] = i==0?dpLeft[0] : dpLeft[i-1];
            }else if(arr[i]==target) {
                dpLeft[i] = 1;
            }else {
                int item = left - target;
                if(mapLeft.containsKey(item)) {
                    int index = mapLeft.get(item);
                    dpLeft[i] = dpLeft[i - 1] > i - index ? i - index : dpLeft[i - 1];
                }else {
                    dpLeft[i] = i==0?dpLeft[0] : dpLeft[i-1];
                }

            }
        }
        int right = 0;
        for(int i=arr.length-1;i>=0;i--) {
            right += arr[i];
            mapRight.put(right, i);
            if(arr[i]>target) {
                dpRight[i] = i==arr.length-1?dpRight[arr.length-1] : dpRight[i+1];
            }else if(arr[i]==target) {
                dpRight[i] = 1;
            }else {
                int item = right - target;
                if(mapRight.containsKey(item)) {
                    int index = mapRight.get(item);
                    dpRight[i] = dpRight[i + 1] > index - i  ? index -i: dpRight[i + 1];
                }else {
                    dpRight[i] = i==arr.length-1?dpRight[arr.length-1] : dpRight[i+1];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++) {
            if(dpLeft[i]!=Integer.MAX_VALUE&&dpRight[i+1]!=Integer.MAX_VALUE) {
                res = dpLeft[i] + dpRight[i+1]<res?dpLeft[i] + dpRight[i+1]:res;
            }
        }
        ArrayUtils.print(dpLeft);
        ArrayUtils.print(dpRight);
        return Integer.MAX_VALUE==res?-1:res;
    }
}
