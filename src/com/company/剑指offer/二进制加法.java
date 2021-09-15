package com.company.剑指offer;

/**
 * @Classname 二进制加法
 * @Date 2021/9/2 1:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二进制加法 {
    public static void main(String[] args) {
        二进制加法 s = new 二进制加法();
        System.out.println(s.addBinary("10", "11"));
    }
    public String addBinary(String a, String b) {
        char[] aChar;
        char[] bChar;
        if(a.length() >= b.length()) {
            aChar = a.toCharArray();
            bChar = b.toCharArray();
        }else {
            aChar = b.toCharArray();
            bChar = a.toCharArray();
        }
        int i = aChar.length - 1;;
        int j = bChar.length - 1;
        int[] arr = new int[aChar.length];
        while (j >= 0) {
            arr[i] = aChar[i] - '0' + bChar[j] - '0';
            i--;
            j--;
        }

        while (i >= 0) {
            arr[i] = aChar[i] - '0';
            i--;
        }
        String res  = "";
        int q = 0;
        for(int z = aChar.length - 1; z >= 0; z--) {
            if(arr[z] + q >= 2) {
                arr[z] = arr[z] + q - 2;
                res = arr[z] + res;
                q = 1;
            }else {
                arr[z] = arr[z] + q;
                res = arr[z] + res;
                q = 0;
            }
        }
        if(q == 1) {
            res = 1 + res;
        }

        return res;
    }
}
