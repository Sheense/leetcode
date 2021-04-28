package com.company.string;

import java.util.*;

public class 替换字符串中的括号内容 {
    public static void main(String[] args) {
        替换字符串中的括号内容 s = new 替换字符串中的括号内容();
        System.out.println(s.evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name","bob"), Arrays.asList("age","two"))));
    }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index<s.length()) {
            while (index<s.length()&&s.charAt(index)!='(') {
                sb.append(s.charAt(index));
                index++;
            }
            if(index<s.length()&&s.charAt(index) =='(') {
                index++;
                String key = "";
                while (index<s.length()&&s.charAt(index)!=')') {
                    key += s.charAt(index);
                    index++;
                }
                sb.append(map.getOrDefault(key, "?"));
                index++;
            }
        }
        return sb.toString();
    }
}
