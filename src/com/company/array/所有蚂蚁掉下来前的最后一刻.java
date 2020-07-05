package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 所有蚂蚁掉下来前的最后一刻 {

    public static void main(String[] args) {
        所有蚂蚁掉下来前的最后一刻 s = new 所有蚂蚁掉下来前的最后一刻();
        System.out.println(s.getLastMoment(4, new int[]{4,3},new int[]{0,1}));
    }
    public int getLastMoment(int n, int[] left, int[] right) {
        int min = n;
        for(int i=0;i<right.length;i++) {
            if(min>right[i]) min = right[i];
        }
        int max = 0;
        for(int i=0;i<left.length;i++) {
            if(max<left[i]) max = left[i];
        }
        return Math.max(n-min,max);

    }
}
