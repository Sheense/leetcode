package com.company.sort;

public class 数组的相对排序 {
    public static void main(String[] args) {
        数组的相对排序 s = new 数组的相对排序();
        System.out.println(s.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for(int i=0;i<arr1.length;i++) count[arr1[i]]++;
        int index = 0;
        for(int i=0;i<arr2.length;i++) {
            while(count[arr2[i]]--!=0) {
                arr1[index++] = arr2[i];
            }
        }
        for(int i=0;i<count.length;i++) {
            while(count[i]-->0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
