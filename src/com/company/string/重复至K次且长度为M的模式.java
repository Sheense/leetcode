package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class 重复至K次且长度为M的模式 {
    public static void main(String[] args) {
        重复至K次且长度为M的模式 s = new 重复至K次且长度为M的模式();
        System.out.println(s.containsPattern(new int[]{3,2,2,1,2,2,1,1,1,2,3,2,2}, 3,2));
    }
    public boolean containsPattern(int[] arr, int m, int k) {
        String string = "";
        for(int i=0;i<arr.length;i++) {
            string += arr[i];
        }
        for(int j = 0;j<arr.length;j++) {
            String str = "";
            int time=0;
            for(int i=m+j;i<=arr.length;i+=m) {
                String item = string.substring(i-m, i);
                if(str.equals("")||!str.equals(item)) {
                    str = item;
                    time = 1;
                }else {
                    time++;
                    if(time==k) return true;
                }
            }
        }
        return false;
    }
}
