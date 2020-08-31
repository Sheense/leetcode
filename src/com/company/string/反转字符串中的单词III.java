package com.company.string;

public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String res = "";
        for(int i=0;i<strings.length;i++) {
            StringBuilder sb = new StringBuilder(strings[i]).reverse();
            res += sb.toString();
            if(i!=strings.length-1) {
                res += " ";
            }
        }
        return res;
    }
}
