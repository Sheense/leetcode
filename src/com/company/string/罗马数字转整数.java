package com.company.string;

public class 罗马数字转整数 {

    public static void main(String[] args) {
        罗马数字转整数 s = new 罗马数字转整数();
        System.out.println(s.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int res=0;
        int index = 0;
        while(index<s.length()){
            int item = getNum(s.charAt(index));
            if(index+1<s.length()&&getNum(s.charAt(index+1))>item) {
                item = getNum(s.charAt(index+1)) - item ;
                index++;
            }
            res += item;
            index++;
        }
        return res;
    }

    public int getNum(char c) {
        switch (c) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }

}
