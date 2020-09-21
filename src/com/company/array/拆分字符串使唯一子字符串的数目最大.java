package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class 拆分字符串使唯一子字符串的数目最大 {
    public static void main(String[] args) {
        拆分字符串使唯一子字符串的数目最大 s = new 拆分字符串使唯一子字符串的数目最大();
        System.out.println(s.maxUniqueSplit("ababccc"));
    }
    public int maxUniqueSplit(String s) {
        return findMax(s, 0, new HashSet<>());

    }

    public int findMax(String s, int index, Set<String> set) {
        if(index >= s.length()) return set.size();
        int max = 0;
        for(int i=index + 1;i<=s.length();i++) {
            String s1 = s.substring(index, i);
            if(!set.contains(s1)) {
                set.add(s1);
                max = Math.max(findMax(s, i, set), max);
                set.remove(s1);
            }
        }
        return max;
    }
}
