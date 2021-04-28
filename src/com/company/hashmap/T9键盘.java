package com.company.hashmap;

import java.util.*;

public class T9键盘 {
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        map.put('1', new HashSet<>(Arrays.asList('!','@','#')));
        map.put('2', new HashSet<>(Arrays.asList('a','b','c')));
        map.put('3', new HashSet<>(Arrays.asList('d','e','f')));
        map.put('4', new HashSet<>(Arrays.asList('g','h','i')));
        map.put('5', new HashSet<>(Arrays.asList('j','k','l')));
        map.put('6', new HashSet<>(Arrays.asList('m','n','o')));
        map.put('7', new HashSet<>(Arrays.asList('p','q','r','s')));
        map.put('8', new HashSet<>(Arrays.asList('t','u','v')));
        map.put('9', new HashSet<>(Arrays.asList('w','x','y','z')));
        List<String> res = new ArrayList<>();
        for(String key : words) {
            if(num.length() == key.length()) {
                boolean flag = true;
                for(int i = 0;i<num.length();i++) {
                    if(!map.get(num.charAt(i)).contains(key.charAt(i))) {
                        flag = false;
                        break;
                    }
                }
                if(flag) res.add(key);
            }
        }
        return res;
    }
}
