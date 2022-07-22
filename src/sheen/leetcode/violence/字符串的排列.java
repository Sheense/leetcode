package sheen.leetcode.violence;

public class 字符串的排列 {

    public static void main(String[] args) {
        字符串的排列 s = new 字符串的排列();
        System.out.println(s.checkInclusion("ab","eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] key = new int[26];
        for(int i=0;i<s1.length();i++) {
            int index = s1.charAt(i)-'a';
            key[index] = key[index]+1;
        }
        String strKey = "";
        for(int i=0;i<26;i++) {
            if(key[i]!=0) {
                strKey += key[i] + (char)(i+'a');
            }
        }
        key = new int[26];
        for(int i=0;i<=s2.length()-s1.length();i++) {
            if(i==0) {
                for(int j=0;j<s1.length();j++) {
                    int index = s2.charAt(j)-'a';
                    key[index] = key[index]+1;
                }
            }else {
                key[s2.charAt(i-1)-'a']--;
                key[s2.charAt(i+s1.length()-1)-'a']++;
            }
            String str = "";
            for(int j=0;j<26;j++) {
                if(key[j]!=0) {
                    str += key[j] + (char)(j+'a');
                }
            }
            if(str.equals(strKey)) return true;
        }
        return false;
    }
}
