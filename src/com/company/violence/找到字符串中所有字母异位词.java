package com.company.violence;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        找到字符串中所有字母异位词 s = new 找到字符串中所有字母异位词();
        System.out.println(s.findAnagrams("cbaebabacd","abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length()) return res;
        int[] key = new int[26];
        for(int i=0;i<p.length();i++) {
            int index = p.charAt(i)-'a';
            key[index] = key[index]+1;
        }
        String strKey = "";
        for(int i=0;i<26;i++) {
            if(key[i]!=0) {
                strKey += key[i] +"#"+ (char)(i+'a');
            }
        }
        key = new int[26];
        for(int i=0;i<=s.length()-p.length();i++) {
            if(i==0) {
                for(int j=0;j<p.length();j++) {
                    int index = s.charAt(j)-'a';
                    key[index] = key[index]+1;
                }
            }else {
                key[s.charAt(i-1)-'a']--;
                key[s.charAt(i+p.length()-1)-'a']++;
            }
            String str = "";
            for(int j=0;j<26;j++) {
                if(key[j]!=0) {
                    str += key[j] +"#"+ (char)(j+'a');
                }
            }
            if(str.equals(strKey)) {
                res.add(i);
            }
        }
        return res;
    }
}
