package com.company.array;

public class 上升下降字符串 {
    public String sortString(String s) {
        int [] arr = new int[26];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
        }
        char[] res = new char[s.length()];
        int index =0;
        while(index<res.length) {
            for(int i=0;i<arr.length;i++) {
                if(arr[i]!=0) {
                    res[index++] = (char)(i+'a');
                    arr[i]--;
                }
            }
            for(int i=arr.length-1;i>=0;i--) {
                if(arr[i]!=0) {
                    res[index++] = (char)(i+'a');
                    arr[i]--;
                }
            }
        }
        return String.valueOf(res);
    }
}
