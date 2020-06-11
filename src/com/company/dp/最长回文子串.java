package com.company.dp;

public class 最长回文子串 {
    //马拉车算法
    /*public String longestPalindrome(String s) {
        char main[] = new char[2*(s.length())+1];
        char sub[] = s.toCharArray();
        int j = 0;
        for(int i=0;i<sub.length;i++) {
            main[j++]='#';
            main[j++]=sub[i];
        }
        main[j]='#';
        String res = findTheLong(main);
        return res;
    }
    public String findTheLong(char[] main) {
        int [] next = new int[main.length];
        int bound = 0;
        int m = 0;
        for(int i=0;i<main.length;i++) {
            next[i]=1;
            if(i<bound) {
                next[i]=next[m-(i-m)]>bound-i?bound-i:next[m-(i-m)];
            }
            while(i-next[i]>=0&&i+next[i]<main.length&&main[i-next[i]]==main[i+next[i]]) {
                next[i]++;
            }
            if(bound<i+next[i]) {
                bound = i+next[i];
                m = i;
            }
        }
        StringBuffer res = new StringBuffer();
        int max = Integer.MIN_VALUE;
        int r = 0;
        for(int i=0;i<next.length;i++) {
            if(next[i]>max) {
                max = next[i];
                r = i;
            }
        }
        for(int i=r-max+1;i<=r+max-1&&i<main.length&&i>=0;i++) {
            if(main[i]!='#') res.append(main[i]);
        }
        return res.toString();
    }*/


    public static void main(String[] args) {
        最长回文子串 s = new 最长回文子串();
        System.out.println(s.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        boolean[][] map = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            map[i][i] = true;
        }
        String res = s.substring(0,1);
        int length = 1;
        for(int i=0;i<=s.length()-2;i++) {
            for(int j=0;j<s.length()-(i+1);j++) {
                map[j][j+i+1] = s.charAt(j)==s.charAt(j+i+1)&&(map[j+1][j+i]||i==0);
                if(map[j][j+i+1]) {
                    if(i+2>length) {
                        res = s.substring(j, j+i+2);
                    }
                }
            }
        }
        return res;
    }
}
