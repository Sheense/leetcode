package com.company.string;

public class 交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i<word1.length()) {
            if(i<word2.length()) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }else {
                break;
            }
            i++;
        }
        if(i == word1.length()) {
            if(i<word2.length()) {
                sb.append(word2.substring(i));
            }
        }else {
            sb.append(word1.substring(i));
        }
        return sb.toString();
    }
}
