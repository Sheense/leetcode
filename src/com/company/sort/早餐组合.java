package com.company.sort;

import java.util.Arrays;
import java.util.Collections;

public class 早餐组合 {
    public static void main(String[] args) {
        早餐组合 s = new 早餐组合();
        System.out.println(s.breakfastNumber(new int[]{2,2}, new int[]{2,3,3,4,5},3));
    }
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long res = 0;
        for(int i=0;i<staple.length&&staple[i]<x;i++) {
            int yu = x - staple[i];
            int left = 0;
            int right = drinks.length-1;
            while(left<=right) {
                int mid = (left+right)/2;
                if(drinks[mid]>yu) {
                    right = mid -1;
                }else if(drinks[mid]<yu) {
                    left = mid + 1;
                }else {
                    right = mid;
                    break;
                }
            }
            while(right+1<drinks.length&&drinks[right+1]<=yu) {
                right++;
            }
            res = (res + right+1)%1000000007;
        }
        return (int)res;
    }


}
