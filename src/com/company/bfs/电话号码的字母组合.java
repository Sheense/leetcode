package com.company.bfs;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {

        电话号码的字母组合 s = new 电话号码的字母组合();
        System.out.println(s.letterCombinations("25468754948"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.equals("")) return new ArrayList<>();
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>();
        char[] first = charge(chars[0]);
        for(int i=0;i<first.length;i++) {
            res.add(String.valueOf(first[i]));
        }
        for(int i=1;i<chars.length;i++) {
            int length = res.size();
            char key = chars[i];
            for(int j=0;j<length;j++) {
                int index = 0;
                char[] value = charge(key);
                String old = res.get(j);
                res.set(j, old + value[index++]);
                while(index<value.length) {
                    res.add(old+value[index++]);
                }
            }
        }
        return res;
    }

    public char[] charge(char c) {
        switch (c) {
            case '2' : return new char[]{'a','b','c'};
            case '3' : return new char[]{'d','e','f'};
            case '4' : return new char[]{'g','h','i'};
            case '5' : return new char[]{'j','k','l'};
            case '6' : return new char[]{'m','n','o'};
            case '7' : return new char[]{'p','q','r','s'};
            case '8' : return new char[]{'t','u','v'};
            case '9' : return new char[]{'w','x','y','z'};
            default: return new char[0];
        }
    }
}
