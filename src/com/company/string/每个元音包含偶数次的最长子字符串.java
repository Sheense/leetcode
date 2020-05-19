package com.company.string;

public class 每个元音包含偶数次的最长子字符串 {

    public static void main(String[] args) {
        每个元音包含偶数次的最长子字符串 s = new 每个元音包含偶数次的最长子字符串();
        System.out.println(s.findTheLongestSubstring("eleetminicoworoep"));
    }

    public int findTheLongestSubstring(String s) {
       int[] hash = new int[32];
       for(int i=0;i<32;i++) {
           hash[i] = -1;
       }
       int max = 0;
       int pre = 0;
       for(int i=0;i<s.length();i++) {
           int index = 0;
           switch (s.charAt(i)) {
               case 'a':index=1;break;
               case 'e':index=2;break;
               case 'i':index=4;break;
               case 'o':index=8;break;
               case 'u':index=16;break;
           }
           if(i!=0) {
               index = index^pre;
           }
           pre = index;
           if(index==0) {
               max = max>i+1?max:i+1;
               continue;
           }
           if(hash[index]==-1) {
               hash[index] = i;
           }else {
               max = max>i-hash[index]?max:i-hash[index];
           }
       }
       return max;
    }
}
