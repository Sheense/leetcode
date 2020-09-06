package com.company.math;

import com.company.window.乘积小于K的子数组;

public class 数字1的个数 {
    public static void main(String[] args) {
        数字1的个数 s = new 数字1的个数();
        System.out.println(s.countDigitOne(13));
    }
    public int countDigitOne(int n) {
        int[] map = new int[9];
        for(int i=0;i<map.length;i++) {
            if(i == 0) map[i] = 1;
            else map[i] = map[i-1]*9 + 1;
        }
        int res = 0;
        String str = String.valueOf(n);
        char[] cs = str.toCharArray();
        for(int i=cs.length-2;i>=0;i--) {
            res += map[i];
        }
        if(cs[0]=='1') {
            int i = 1;
            while(i<str.length()&&str.charAt(i)==0) {
                i++;
            }
            if(i==str.length()) {
                return res +1;
            }
            return res + Integer.valueOf(str.substring(i)) + 1;
        }
        int wei = cs.length-2;
        for(int i=0;i<cs.length;i++) {
            if(i==cs.length-1&&cs[i]>='1') {
                res++;
                continue;
            }
            res++;
            res += ((cs[i]-'0')-1)*map[wei];
            wei--;
        }
        return res;
    }
}
