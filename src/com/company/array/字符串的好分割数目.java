package com.company.array;

public class 字符串的好分割数目 {
    public int numSplits(String s) {
        int[] p = new int[26];
        int[] q = new int[26];
        for(int i=0;i<s.length();i++) {
            p[s.charAt(i)-'a']++;
        }
        int res = 0;
        for(int i=0;i<s.length();i++) {
            p[s.charAt(i)-'a']--;
            q[s.charAt(i)-'a']++;
            int num_p = 0;
            int num_q = 0;
            for(int j=0;j<26;j++) {
                if(p[j]!=0) num_p++;
                if(q[j]!=0) num_q++;
            }
            if(num_p==num_q) res++;
        }
        return res;
    }
}
