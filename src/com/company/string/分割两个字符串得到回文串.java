package com.company.string;

public class 分割两个字符串得到回文串 {

    public static void main(String[] args) {
        System.out.println(new StringBuilder("yjgpzbezspnnpszebzmhvp").reverse());
    }
    public boolean checkPalindromeFormation(String a, String b) {
        if(judge(a)||judge(b)) return true;
        if(judge(a,b)||judge(b,a)) return true;
        return false;
    }

    public boolean judge(String a, String b) {
        int i = 0;
        int j = b.length()-1;
        while(i<a.length()-1&&a.charAt(i)==b.charAt(j)) {
            if(i==j-1||i==j-2) return true;
            i++;
            j--;
        }
        if(judge(a.substring(i, j+1))||judge(b.substring(i, j+1))) return true;
        return false;
    }

    public boolean judge(String a) {
        for(int i=0;i<a.length()/2;i++) {
            if(a.charAt(i)!=a.charAt(a.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
