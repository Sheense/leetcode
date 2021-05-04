package com.company.string;

public class 将所有数字用字符替换 {
    public String replaceDigits(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(i%2==0) {
                res.append(s.charAt(i));
            }else {
                res.append((char)(s.charAt(i-1)+(s.charAt(i)-'0')));
            }
        }
        return res.toString();
    }
}
