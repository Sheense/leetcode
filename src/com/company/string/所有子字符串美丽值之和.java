package com.company.string;

public class 所有子字符串美丽值之和 {
    public static void main(String[] args) {
        所有子字符串美丽值之和 s = new 所有子字符串美丽值之和();
        System.out.println(s.beautySum("aabcb"));
    }
    public int beautySum(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i) - 'a'] ++;
        }
        int res = 0;
        for(int i=0;i<s.length()-1;i++) {
            int[] copy = new int[26];
            for(int j=0;j<26;j++) copy[j] = arr[j];
            for(int j=s.length()-1;j>i;j--) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int z=0;z<copy.length;z++) {
                    if(max<copy[z]&&copy[z]!=0) max = copy[z];
                    if(min>copy[z]&&copy[z]!=0) min = copy[z];
                }
                res += (max-min);
                copy[s.charAt(j) - 'a']--;
            }
            arr[s.charAt(i) - 'a']--;
        }
        return res;
    }
}
