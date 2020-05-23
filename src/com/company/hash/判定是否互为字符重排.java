package com.company.hash;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 判定是否互为字符重排 {

    public static void main(String[] args) {
        判定是否互为字符重排 s = new 判定是否互为字符重排();
        System.out.println(s.CheckPermutation("abc","bac"));
    }
    public boolean CheckPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(new String(c1).equals(new String(c2))) {
            return true;
        }
        return false;
    }
}
