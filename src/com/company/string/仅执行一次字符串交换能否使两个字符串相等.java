package com.company.string;

public class 仅执行一次字符串交换能否使两个字符串相等 {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int a1 = -1;
        int a2 = -1;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                if(a1 == -1) a1 = i;
                else if(a2 == -1) a2 = i;
                else return false;
            }
        }
        if(a1==-1 && a1==a2) return true;
        if(a1 == -1 || a2 == -1) return false;
        if(s1.charAt(a1)==s2.charAt(a2)&&s1.charAt(a2)==s2.charAt(a1)) return true;
        return false;
    }
}
