package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 查找常用字符 {
    public static void main(String[] args) {
        查找常用字符 s = new 查找常用字符();
        System.out.println(s.commonChars(new String[]{
                "cool","lock","cook"
        }));
    }
    public List<String> commonChars(String[] A) {
        int[] a = new int[26];
        for(int i=0;i<A.length;i++) {
            int[] b = new int[26];
            for(int j=0;j<A[i].length();j++) {
                b[A[i].charAt(j)-'a']++;
            }
            if(i==0) a = b;
            else {
                for(int j=0;j<26;j++) {
                    a[j] = Math.min(b[j],a[j]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<26;i++) {
            for(int j=0;j<a[i];j++) {
                res.add(String.valueOf((char)('a'+i)));
            }
        }
        return res;
    }
}
