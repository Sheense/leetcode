package com.company.array;

/**
 * @Classname 赎金信
 * @Date 2021/12/4 1:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 赎金信 {
    public static void main(String[] args) {
        赎金信 s = new 赎金信();
        System.out.println(s.canConstruct("fihjjjjei","hjibagacbhadfaefdjaeaebgi"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            m[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            r[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0; i < m.length; i++) {
            if(r[i] > m[i]) {
                return false;
            }
        }
        return true;
    }
}
