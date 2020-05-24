package com.company.array;

public class 二进制求和 {

    public static void main(String[] args) {
        二进制求和 s= new 二进制求和();
        System.out.println(s.addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {
        int i =a.length()-1;
        int j =b.length()-1;
        String res = "";
        int flag = 0;
        while(i>=0&&j>=0) {
            int n = flag + a.charAt(i)-'0' + b.charAt(j)-'0';
            if(n>=2) flag = 1;
            else flag = 0;
            n%=2;
            res = n + res;
            i--;
            j--;
        }
        if(i==-1) {
            while(j>=0) {
                int num = b.charAt(j) -'0'+flag;
                if(num>=2) flag = 1;
                else flag = 0;
                num %= 2;
                res = num+res;
                j--;
            }
        }
        if(j==-1) {
            while(i>=0) {
                int num = a.charAt(i) - '0' + flag;
                if(num>=2) flag = 1;
                else flag =0;
                num%=2;
                res = num+res;
                i--;
            }
        }
        if(flag==1) res = flag + res;
        return res;
    }
}
