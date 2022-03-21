package com.company.array;

/**
 * @Classname 最长的美好子字符串
 * @Date 2022/2/1 2:47 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长的美好子字符串 {
    public static void main(String[] args) {
        最长的美好子字符串 s = new 最长的美好子字符串();
        System.out.println(s.longestNiceSubstring("cChH"));
    }
    public String longestNiceSubstring(String s) {
        int max = 0;
        String res = "";
        for(int i = 0; i <s.length(); i++) {
            for(int j = 2; j <= s.length() - i; j++) {
                int[] a = new int[26];
                int[] b = new int[26];
                for(int z = i; z < i + j; z++) {
                    if(s.charAt(z) >= 'a' && s.charAt(z) <= 'z') {
                        a[s.charAt(z) - 'a']++;
                    }else {
                        b[s.charAt(z) - 'A']++;
                    }
                }
                if(check(a, b) && j > max)  {
                    res = s.substring(i, i + j);
                    max = j;
                }
            }
        }
        return res;
    }

    public boolean check(int[] a, int [] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] > 0 && b[i] == 0 || a[i] ==0 && b[i] > 0) {
                return false;
            }
        }
        return true;
    }


}
