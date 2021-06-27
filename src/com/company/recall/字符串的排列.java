package com.company.recall;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 字符串的排列 {
    public String[] permutation(String s) {
        Set<String> set= recall(new HashSet<>(), 0, s);
        String[] res = new String[set.size()];
        int index = 0;
        for(String value:set) {
            res[index++] = value;
        }
        return res;
    }

    public Set<String> recall(Set<String> set, int index, String s) {

        if(index == s.length() - 1) {
            set.add(String.valueOf(s.charAt(index)));
            return set;
        }
        set = recall(set, index + 1, s);

        Set<String> copy = new HashSet<>();
        for(String value: set) {
            for(int i = 0; i <= value.length();i++) {
                String item = "";
                if(i == 0) {
                    item = s.charAt(index) + value;
                }else if(i == value.length()) {
                    item = value + s.charAt(index);
                }else {
                   item = value.substring(0, i) + s.charAt(index) + value.substring(i);
                }
                copy.add(item);
            }
        }
        return copy;

    }
}
