package com.company.hash;

import java.util.*;

public class 变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs) {
            int[] hash = new int[26];
            for(int i=0;i<str.length();i++) {
                int index = str.charAt(i)-'a';
                hash[index]++;
            }
            StringBuilder stringBuffer = new StringBuilder();
            for(int i=0;i<hash.length;i++) {
                stringBuffer.append(hash[i]).append("#");
            }
            List<String> list = map.computeIfAbsent(stringBuffer.toString(), x->new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
