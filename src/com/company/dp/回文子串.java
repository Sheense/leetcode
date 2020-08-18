package com.company.dp;

import java.util.LinkedList;
import java.util.Queue;

public class 回文子串 {
    public static void main(String[] args) {
        回文子串 s = new 回文子串();
        System.out.println(s.countSubstrings("aaa"));
    }
    /*public int countSubstrings(String s) {
        boolean[][] map = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<s.length()-i;j++){
                if(i==0) {
                    map[j][j] = true;
                    count++;
                }else if(i==1){
                    if(s.charAt(j)==s.charAt(j+1)) {
                        map[j][j+1] = true;
                        count++;
                    }
                }else {
                    if(s.charAt(j) == s.charAt(j+i)&&map[j+1][j+i-1]) {
                        map[j][j+i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }*/
    public int countSubstrings(String s) {
        int count = s.length();
        Queue<Integer> start = new LinkedList<>();
        Queue<Integer> end = new LinkedList<>();
        for(int i=0;i<s.length()-1;i++) {
            start.offer(i);
            end.offer(i);
            if(s.charAt(i)==s.charAt(i+1)) {
                start.offer(i);
                end.offer(i+1);
                count++;
            }
        }
        while(!start.isEmpty()) {
            int size = start.size();
            while(size--!=0) {
                int begin = start.poll();
                int after = end.poll();
                if(begin-1<0||after+1==s.length()) {
                    continue;
                }else if(s.charAt(begin-1)==s.charAt(after+1)) {
                    count++;
                    start.offer(begin-1);
                    end.offer(after+1);
                }
            }
        }
        return count;
    }
}
