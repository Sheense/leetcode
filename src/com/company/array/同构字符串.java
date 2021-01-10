package com.company.array;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        String mod1 = getMod(s);
        String mod2 = getMod(t);
        return mod1.equals(mod2);
    }

    public String getMod(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        String str = "";
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                str += map.get(s.charAt(i));
            }else {
                str += index;
                map.put(s.charAt(i), index);
                index++;
            }
        }
        return str;
    }
}
