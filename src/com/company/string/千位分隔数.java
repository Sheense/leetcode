package com.company.string;

public class 千位分隔数 {
    public String thousandSeparator(int n) {
        String value = String.valueOf(n);
        String res ="";
        int index = 0;
        for(int i=value.length()-1;i>=0;i--) {
            if(index==3) {
                res = '.'+ res;
                index = 0;
            }
            index++;
            res = value.charAt(i) + res;
        }
        return res;
    }
}
