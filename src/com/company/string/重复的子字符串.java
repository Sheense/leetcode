package com.company.string;

public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<=s.length()/2;i++) {
            if(s.length()%i==0) {
                boolean flag = true;
                String temp = s.substring(0,i);
                int end = i+i;
                while(end<=s.length()) {
                    if(!s.substring(end-i, end).equals(temp)) {
                        flag = false;
                        break;
                    }
                    end+=i;
                }
                if(flag) return true;
            }
        }
        return false;
    }
}
