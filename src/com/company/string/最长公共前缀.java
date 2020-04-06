package com.company.string;

public class 最长公共前缀 {
    public static void main(String[] args) {
        最长公共前缀 s = new 最长公共前缀();
        String[] str = {"f","flow","flight"};
        System.out.println(s.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        if(strs.length==0) return sb.toString();
        while(true) {
            int i=0;
            char p = ' ';
            do {
                if(strs[i].length()>index) {
                    if(i==0) p = strs[i].charAt(index);
                    else {
                        if(p!=strs[i].charAt(index)) return sb.toString();
                    }
                }else {
                    return sb.toString();
                }
                i++;
            }while(i<strs.length);
            sb.append(p);
            index++;
        }
    }
}
