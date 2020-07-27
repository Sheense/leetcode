package com.company.array;

public class 灯泡开关IV {
    public static void main(String[] args) {
        灯泡开关IV s = new 灯泡开关IV();
        System.out.println(s.minFlips("001011101"));
    }
    public int minFlips(String target) {
        boolean noOne = true;
        int res = 0;
        int i = 0;
        while (i<target.length()) {
            if(target.charAt(i)=='1'&&noOne) {
                res++;
                noOne = false;
            }
            if(!noOne&&target.charAt(i)=='0') {
                res++;
                i++;
                while(i<target.length()&&target.charAt(i)=='0') {
                    i++;
                }
                if(i<target.length()&&target.charAt(i)=='1') {
                    res++;
                }
            }
            i++;
        }
        return res;
    }
}
