package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 有重复字符串的排列组合 {
    public static void main(String[] args) {
        有重复字符串的排列组合 s = new 有重复字符串的排列组合();
        ArrayUtils.print(s.permutation("pppppHHHH"));
    }
    public String[] permutation(String S) {
        Set<String> set = new HashSet<>();
        set.add(String.valueOf(S.charAt(0)));
        for(int i=1;i<S.length();i++) {
            Set<String> temp = new HashSet<>();
            for(String value : set) {
                for(int j = 0;j<=value.length();j++) {
                    if(j==0) {
                        temp.add(S.charAt(i) + value);
                    }else if(j == value.length()) {
                        temp.add(value + S.charAt(i));
                    }else {
                        temp.add(value.substring(0, j) + S.charAt(i) + value.substring(j));
                    }
                }
            }
            set = temp;
        }
        String[] res = new String[set.size()];
        int index = 0;
        for(String value:set) res[index++] = value;
        return res;
    }


}
