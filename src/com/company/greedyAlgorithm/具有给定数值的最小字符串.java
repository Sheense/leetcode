package com.company.greedyAlgorithm;

public class 具有给定数值的最小字符串 {
    public static void main(String[] args) {
        具有给定数值的最小字符串 s = new 具有给定数值的最小字符串();
        System.out.println(s.getSmallestString(3, 27));
    }
    public String getSmallestString(int n, int k) {
        int aNum = n;
        k -= n;
        int zNum = k/25;
        int zYu = k%25;
        aNum -= zNum;
        if(zYu>0) aNum--;
        String res = "";
        res += recall(aNum, 'a');
        if(zYu>0) res += (char)('a'+zYu);
        res += recall(zNum,'z');
        return res;
    }

    public String recall(int num, char c) {
        if(num==0) return "";
        if(num==1) return String.valueOf(c);
        String s = recall(num/2, c);
        if(num%2==0) {
            return s + s;
        }else {
            return s + s + c;
        }
    }
}
