package com.company.array;

public class 两个相同字符之间的最长子字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] v =  new int[26];
        int max = -1;
        for(int i=0;i<v.length;i++) v[i] = -1;
        for(int i=0;i<s.length();i++) {
            if(v[s.charAt(i)-'a']==-1) {
                v[s.charAt(i) - 'a'] = i;
            }else {
                max = Math.max(max, i-v[s.charAt(i)-'a']-1);
            }
        }
        return max;
    }
}
