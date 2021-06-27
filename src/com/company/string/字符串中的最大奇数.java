package com.company.string;

public class 字符串中的最大奇数 {
    public String largestOddNumber(String num) {
        int end = -1;
        for(int i = 0; i< num.length(); i++) {
            if((num.charAt(i) - '0') % 2 == 1) {
                end = i;
            }
        }
        if(end == -1) return "";
        return num.substring(0, end + 1);
    }
}
