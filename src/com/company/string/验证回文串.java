package com.company.string;

import java.util.HashSet;
import java.util.Set;

public class 验证回文串 {
    public static void main(String[] args) {
        验证回文串 s = new 验证回文串();
        System.out.println(s.isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;
        Set<Character> chars = new HashSet<>();
        for(int z=0;z<26;z++) {
            chars.add((char)('a'+z));
            chars.add((char)('A'+z));
        }
        Set<Character> nums = new HashSet<>();
        for(int z=0;z<10;z++) {
            nums.add((char)('0'+z));
        }
        while(i<j) {
            while(!chars.contains(s.charAt(i))&&!nums.contains(s.charAt(i))&&i<j) {
                i++;
            }
            while(!chars.contains(s.charAt(j))&&!nums.contains(s.charAt(j))&&i<j) {
                j--;
            }
            if(i<j) {
                if(nums.contains(s.charAt(i))&&nums.contains(s.charAt(j))) {
                    if(s.charAt(i)!=s.charAt(j)) return false;
                }else {
                    if(!s.substring(i,i+1).equalsIgnoreCase(s.substring(j,j+1))) return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

}
