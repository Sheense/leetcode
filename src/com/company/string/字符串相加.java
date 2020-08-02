package com.company.string;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int pre = 0;
        String res = "";
        while(i>=0||j>=0) {
            if(i==-1) {
                while(j>=0) {
                    int n = pre + num2.charAt(j--) - '0';
                    if(n>=10) {
                        pre = 1;
                    }else {
                        pre = 0;
                    }
                    n%=10;
                    res = n+res;
                }
                break;
            }
            if(j==-1) {
                while(i>=0) {
                    int n = pre + num1.charAt(i--) - '0';
                    if(n>=10) {
                        pre = 1;
                    }else {
                        pre = 0;
                    }
                    n%=10;
                    res = n+res;
                }
                break;
            }
            char c1 = num1.charAt(i--);
            char c2 = num2.charAt(j--);
            int n = c1-'0'+c2-'0' +pre;
            if(n>=10) {
                pre = 1;
                n%=10;
            }else {
                pre = 0;
            }
            res =  n+res;
        }
        if(pre==1) res = pre+res;
        return res;
    }
}
