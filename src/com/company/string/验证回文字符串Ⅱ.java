package com.company.string;

public class 验证回文字符串Ⅱ {


    public static void main(String[] args) {
        验证回文字符串Ⅱ s = new 验证回文字符串Ⅱ();
        System.out.println(s.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public boolean validPalindrome(String s) {
        boolean flag = false;
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(i==18){
                System.out.println();
            }
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }else {
                if(flag) {
                    if(i+1==j&&s.length()%2==0) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    if(i+1==j&&s.length()%2==0) {
                        return true;
                    }else {
                        if(s.charAt(i+1)==s.charAt(j)&&(i+1==j||s.charAt(i+2)==s.charAt(j-1))) {
                            i++;
                            flag = true;
                        }else if(s.charAt(i)==s.charAt(j-1)&&(j-1==i||s.charAt(j-2)==s.charAt(i+1))) {
                            j--;
                            flag = true;
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
