package com.company.array;

public class 满足三条件之一需改变的最少字符数 {
    public static void main(String[] args) {
        满足三条件之一需改变的最少字符数 s = new 满足三条件之一需改变的最少字符数();
        System.out.println(s.minCharacters("dabadd", "cda"));
    }
    public int minCharacters(String a, String b) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int index1 = 0;
        int index2 = 0;
        while (index1<a.length()||index2<b.length()) {
            if(index1<a.length()) {
                arr1[a.charAt(index1++)-'a']++;
            }
            if(index2<b.length()) {
                arr2[b.charAt(index2++)-'a']++;
            }
        }
        for(int i=1;i<26;i++) {
            arr1[i] = arr1[i] + arr1[i-1];
            arr2[i] = arr2[i] + arr2[i-1];
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            if(i==0) {
                res = Math.min(res, a.length()-arr1[i] + b.length() - arr2[i]);
            }else  {
                res = Math.min(res, arr1[i-1] + b.length() - arr2[i-1]);
                res = Math.min(res, arr2[i-1] + a.length() - arr1[i-1]);
                res = Math.min(res, a.length() - (arr1[i]-arr1[i-1]) + b.length() - (arr2[i]-arr2[i-1]));
            }
        }
        return res;
    }
}
