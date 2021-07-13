package com.company.stack;

import java.util.*;

public class 原子的数量 {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int index = 0;
        while (index < formula.length()) {
            if(formula.charAt(index) >= 'A' && formula.charAt(index) <= 'Z') {
                String item = String.valueOf(formula.charAt(index++));
                if(index < formula.length() && formula.charAt(index)>='a' && formula.charAt(index)<='z') {
                    item += formula.charAt(index++);
                }
                int[] arr = getNum(index, formula);
                index = arr[1];
                Map<String, Integer> map = stack.peek();
                map.put(item, map.getOrDefault(item, 0) + arr[0]);
            }else if(formula.charAt(index) == '(') {
                Map<String, Integer> map = new HashMap<>();
                index++;
                stack.push(map);
            }else if(formula.charAt(index) == ')') {
                index ++;
                int[] arr = getNum(index, formula);
                index = arr[1];
                Map<String,Integer> map = stack.pop();
                Map<String, Integer> p = stack.peek();
                for(String key:map.keySet()) {
                    p.put(key, p.getOrDefault(key, 0) + map.get(key) * arr[0]);
                }
            }
        }
        Map<String, Integer> map = stack.pop();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        String res = "";
        for(String item : list) {
            res += item + (map.get(item) == 1 ? "" : map.get(item));
        }
        return res;
    }

    public int[] getNum(int index, String formula) {
        int res = 0;
        while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9') {
            res *= 10;
            res += (formula.charAt(index) - '0');
            index++;
        }
        if(res==0) res=1;
        return new int[]{res, index};
    }
}
