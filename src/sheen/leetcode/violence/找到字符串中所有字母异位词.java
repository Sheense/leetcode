package sheen.leetcode.violence;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        找到字符串中所有字母异位词 s = new 找到字符串中所有字母异位词();
        System.out.println(s.findAnagrams("cbaebabacd","abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[][] arr = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++) {
            if(i == 0) {
                arr[i] = new int[26];
                arr[i][s.charAt(0) - 'a']++;
            }else {
                arr[i] = new int[26];
                for(int j = 0; j < arr[i-1].length; j ++) {
                    arr[i][j] = arr[i-1][j];
                }
                arr[i][s.charAt(i) - 'a']++;
            }
        }


        int[] temp = new int[26];
        for(int i = 0; i < p.length(); i++) {
            temp[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = p.length() - 1; i < arr.length; i++) {
            if(i == p.length() - 1) {
                if(check(arr[i], temp)) {
                    res.add(0);
                }
            }else {
                int[] a = arr[i];
                int[] b = arr[i - p.length()];
                int[] c = new int[26];
                for(int j = 0; j < a.length; j++) {
                    c[j] = a[j] - b[j];
                }
                if(check(c, temp)) {
                    res.add(i - p.length() + 1);
                }
            }
        }
        return res;
    }

    public boolean check(int [] a, int [] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    /*public List<Integer> findAnagrams(String s, String p) {
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
    }*/
}
