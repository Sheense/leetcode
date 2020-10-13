package com.company.string;

public class 宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        boolean[] a = new boolean[26];
        boolean[] b = new boolean[26];
        for(int i=0;i<J.length();i++) {
            if(J.charAt(i)>='a'&&J.charAt(i)<='z') {
                a[J.charAt(i)-'a']=true;
            }else {
                b[J.charAt(i)-'A']=true;
            }
        }
        int res = 0;
        for(int i=0;i<S.length();i++) {
            if(J.charAt(i)>='a'&&J.charAt(i)<='z') {
                if(a[S.charAt(i)-'a']) {
                    res++;
                }
            }else {
                if(b[S.charAt(i)-'A']) {
                    res++;
                }
            }
        }
        return res;
    }
}
