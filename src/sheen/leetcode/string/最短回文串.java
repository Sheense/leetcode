package sheen.leetcode.string;

import java.util.Arrays;

public class 最短回文串 {
    public static void main(String[] args) {
        最短回文串 s = new 最短回文串();
        System.out.println(s.shortestPalindrome("abcd"));
    }
    public String shortestPalindrome(String s) {
        String res = "";
        int[] mod = new int[s.length()];
        int j = -1;
        int i = 1;
        Arrays.fill(mod, -1);
        while(i<s.length()) {
            if(j==-1||s.charAt(i-1)==s.charAt(j)) {
                mod[i] = j+1;
                j = mod[i];
                i++;
            }else {
                j = mod[j];
            }
        }
        int best = 0;
        int index = s.length()-1;
        while(index>=0) {
            if(s.charAt(index) == s.charAt(best)) {
                best++;
                index--;
            }else {
                 best = mod[best];
                 if(best==-1) {
                     best=0;
                     index--;
                 }
            }
        }
        res = new StringBuffer(s.substring(best)).reverse().toString() + s;
        return res;
    }
    public boolean check(String s) {
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
