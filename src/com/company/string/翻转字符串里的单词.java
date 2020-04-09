package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        翻转字符串里的单词 s = new 翻转字符串里的单词();
        System.out.println(s.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        if(s.length()==0) return s;
        int i = 0;
        List<String> list = new ArrayList<>();
        while(i<s.length()) {
            StringBuilder sb = new StringBuilder();
            while(i<s.length()&&s.charAt(i)==' ') i++;
            while(i<s.length()&&s.charAt(i)!=' ') {
                sb.append(s.charAt(i));
                i++;
            }
            if(sb.length()!=0) list.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        for(int j=list.size()-1;j>=0;j--) {
            sb.append(list.get(j)).append(" ");
        }
        if(sb.length()==0) return "";
        return sb.substring(0, sb.length()-1);
    }
}
