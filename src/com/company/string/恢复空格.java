package com.company.string;

import com.company.recall.复原IP地址;

import java.util.*;

public class 恢复空格 {

    public static void main(String[] args) {
        恢复空格 s = new 恢复空格();
        System.out.println(s.respace(new String[]{"potimzz"}, "potimzzpotimzz"));
    }
    public int respace(String[] dictionary, String sentence) {
        if(sentence.length()==0) return 0;
        int [] dp = new int[sentence.length()];
        dp[0] = 1;
        for(int i=0;i<dictionary.length;i++) {
            if(sentence.substring(0,1).equals(dictionary[i])) {
                dp[0] = 0;
                break;
            }
        }
        for(int i=1;i<sentence.length();i++) {
            dp[i] = dp[i-1]+1;
            for(int j=0;j<dictionary.length;j++) {
                int length = dictionary[j].length();
                if(i+1>=length&&sentence.substring(i-length+1,i+1).equals(dictionary[j])) {
                    if(i+1==length) {
                        dp[i] = 0;
                        break;
                    }
                    dp[i] = Math.min(dp[i-length],dp[i]);
                }
            }
        }
        return dp[sentence.length()-1];
    }

}
