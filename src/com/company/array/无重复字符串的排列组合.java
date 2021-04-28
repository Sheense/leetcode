package com.company.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 无重复字符串的排列组合 {
    public String[] permutation(String S) {
        Set<Character> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<S.length();i++) {
            queue.offer(String.valueOf(S.charAt(i)));
            set.add(S.charAt(i));
        }
        int len = 1;
        while (len < S.length()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String s = queue.poll();
                for(int j=0;j<S.length();j++) {
                    if(check(s, S.charAt(j))) {
                        queue.offer(s + S.charAt(j));
                    }
                }
            }
            len++;
        }
        String[] res = new String[queue.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public boolean check(String s, char c) {
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == c) return false;
        }
        return true;
    }
}
