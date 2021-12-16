package com.company.recall;

import java.util.*;

public class 删除无效的括号 {

    public static void main(String[] args) {
        删除无效的括号 s = new 删除无效的括号();
        for(String string : s.removeInvalidParentheses("(a)())()")) {
            System.out.println(string);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        recall(set, s.toCharArray(), 0, 0, new StringBuilder());
        int max = 0;
        List<String> res = new ArrayList<>();
        for(String string:set) {
            if(max<string.length()) max = string.length();
        }
        for(String string:set) {
            if(max==string.length()) res.add(string);
        }
        return res;
    }

    public void recall(Set<String> set,char chars[], int leftSize, int index, StringBuilder now) {
        if(chars.length ==  index) {
            if(leftSize == 0) {
                set.add(now.toString());
            }
            return;
        }
        if(chars[index]=='(') {
            StringBuilder sb = new StringBuilder(now);
            recall(set, chars, leftSize + 1, index+1,  sb.append(chars[index]));

            recall(set, chars, leftSize, index+1,  now);
        }else if(chars[index] ==')') {
            if(leftSize == 0) {
                recall(set, chars, leftSize, index+1, now);
            }else {
                StringBuilder sb = new StringBuilder(now);
                recall(set, chars, leftSize - 1, index+1, sb.append(chars[index]));

                recall(set, chars, leftSize, index+1, now);
            }
        }else {
            StringBuilder sb = new StringBuilder(now);
            recall(set, chars, leftSize, index+1, sb.append(chars[index]));
        }
    }
}
