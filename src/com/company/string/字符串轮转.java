package com.company.string;

public class 字符串轮转 {
    public static void main(String[] args) {
        字符串轮转 s = new 字符串轮转();
        System.out.println(s.isFlipedString("waterbottle","erbottlewat"));
    }
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;
        for(int i=0;i<s1.length();i++) {
            if(s2.substring(0, i+1).equals(s1.substring(s1.length() -1 -i))
                &&s2.substring(i+1).equals(s1.substring(0, s1.length()-1 -i))) {
                return true;
            }
        }
        return false;
    }
}
