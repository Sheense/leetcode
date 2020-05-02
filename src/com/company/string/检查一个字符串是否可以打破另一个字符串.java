package com.company.string;

import java.util.Arrays;

public class 检查一个字符串是否可以打破另一个字符串 {

    public static void main(String[] args) {

    }
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        boolean flag = true;
        for(int i=0;i<chars1.length;i++) {
            if(chars1[i]<chars2[i]) {
                flag =  false;
                break;
            }
        }
        if(!flag) {
            for(int i=0;i<chars1.length;i++) {
                if(chars1[i]>chars2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

}
