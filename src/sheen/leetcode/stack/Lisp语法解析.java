package sheen.leetcode.stack;

import java.util.*;

/**
 * @Classname Lisp语法解析
 * @Date 2022/7/6 12:31 上午
 * @Created by sheen
 * @Description TODO
 */
public class Lisp语法解析 {
    public static void main(String[] args) {
        Lisp语法解析 s = new Lisp语法解析();
        System.out.println(s.evaluate("(let x -2 y x y)"));
    }
    public int evaluate(String expression) {
        Map<String, Stack<Integer>> map = new HashMap<>();
        int[] res = recall(0, expression, map);
        return res[1];
    }

    public int[] recall(int start, String expression, Map<String, Stack<Integer>> map) {
        start++;
        String op = expression.substring(start, start + 3);
        if(op.equals("add")) {
            start += 4;
            int[] res = exec(expression, start, map);
            return new int[] {res[2], res[0] + res[1]};
        }else if(op.equals("let")) {
            start += 4;
            int i = start;
            int ans = 0;
            List<String> names = new ArrayList<>();
            while (i < expression.length() && expression.charAt(i) != ')') {
                if(expression.charAt(i) == '(') {
                    int[] res = recall(i, expression, map);
                    i = res[0];
                    ans = res[1];
                    break;
                }
                Data data = getStr(i, expression);
                String name = data.name;
                i = data.index;
                int v = 0;
                if(i + 1 < expression.length() && expression.charAt(i + 1) == '(') {
                    int[] res = recall(i + 1, expression, map);
                    i = res[0];
                    v = res[1];
                }else if(expression.charAt(i) == ')'){
                    ans = getValue(data, map);
                    i++;
                    break;
                }else {
                    data = getStr(i + 1, expression);
                    v = getValue(data, map);
                    i = data.index + 1;
                }
                map.computeIfAbsent(name, x -> new Stack<>()).push(v);
                names.add(name);
            }
            for(String name : names) {
                map.get(name).pop();
            }
            start = i;
            start = trim(start, expression);
            return new int[]{start, ans};
        }else {
            start += 5;
            int[] res = exec(expression, start, map);
            return new int[] {res[2], res[0] * res[1]};
        }
    }

    public Data getStr(int start, String expression) {
        boolean isNum = true;
        int i = start;
        while (start < expression.length() && expression.charAt(start) != ' ' && expression.charAt(start) != ')' && expression.charAt(start) != '(') {
            if(expression.charAt(start) >= 'a' && expression.charAt(start) <= 'z') {
                isNum = false;
            }
            start++;
        }

        return new Data(expression.substring(i, start), start, isNum);
    }

    public static class Data{
        String name;
        int index;
        boolean isNum;

        public Data(String name, int index, boolean isNum) {
            this.name = name;
            this.index = index;
            this.isNum = isNum;
        }
    }

    public int getValue(Data data, Map<String, Stack<Integer>> map) {
        if(data.isNum) {
            return Integer.valueOf(data.name);
        }
        return map.get(data.name).peek();
    }

    public int trim(int start, String expression) {
        while (start < expression.length() && (expression.charAt(start) == ' ' || expression.charAt(start) == ')')) {
            start++;
        }

        return start;
    }

    public int[] exec(String expression, int start, Map<String, Stack<Integer>> map) {
        int a, b;
        if(expression.charAt(start) == '(') {
            int[] res = recall(start, expression, map);
            start = res[0];
            a = res[1];
            if(expression.charAt(start) == '(') {
                res = recall(start, expression, map);
                start = res[0];
                b = res[1];
            }else {
                Data data = getStr(start, expression);
                b = getValue(data, map);
                start = data.index + 1;
            }
        }else {
            Data data = getStr(start, expression);
            a = getValue(data, map);
            start = data.index + 1;
            if(expression.charAt(start) == '(') {
                int[] res = recall(start, expression, map);
                start = res[0];
                b = res[1];
            }else {
                data = getStr(start, expression);
                b = getValue(data, map);
                start = data.index + 1;
            }
        }
        start = trim(start, expression);
        return new int[]{a, b, start};
    }
}
