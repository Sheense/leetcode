package com.company.test;

public class test3 {
    public static void main(String[] args) {
        test3 s = new test3();
        System.out.println(s.process(new int[]{5,1,7,8,2,10}));
    }

    public int process(int [] arr) {
        int min = arr[0];
        int max = 0;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i] - min);
            if(min>arr[i]) min = arr[i];
        }
        return max;
    }
}
