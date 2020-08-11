package com.company.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 为运算表达式设计优先级 {

    public static void main(String[] args) {
        为运算表达式设计优先级 s = new 为运算表达式设计优先级();
        System.out.println(s.diffWaysToCompute("2*3-4*5"));
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<String> strings = new ArrayList<>();
        int i = 0;
        while(i<input.length()) {
            if(input.charAt(i)>='0'&&input.charAt(i)<='9') {
                int num = 0;
                while(i<input.length()&&input.charAt(i)>='0'&&input.charAt(i)<='9') {
                    num*=10;
                    num+=input.charAt(i++)-'0';
                }
                strings.add(String.valueOf(num));
            }else {
                strings.add(String.valueOf(input.charAt(i++)));
            }
        }
        List<Integer> res = conquer(strings, 0, strings.size()-1);
        return res;
    }

    public List<Integer> conquer(List<String> strings, int start, int end) {
        if (start == end) {
            return Arrays.asList(Integer.parseInt(strings.get(start)));
        }
        if(end - start == 2) {
            return Arrays.asList(compute(Integer.parseInt(strings.get(start)), Integer.parseInt(strings.get(end)), strings.get(start+1).charAt(0)));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = start; i < end - 1; i++) {
            if (strings.get(i).length() == 1 && (strings.get(i).charAt(0) < '0' || strings.get(i).charAt(0) > '9')) {
                continue;
            }
            List<Integer> a = conquer(strings, start, i);
            List<Integer> b = conquer(strings, i + 2, end);
            for (int j = 0; j < a.size(); j++) {
                for (int z = 0; z < b.size(); z++) {
                    int num = compute(a.get(j), b.get(z), strings.get(i + 1).charAt(0));
                    res.add(num);
                }
            }
        }
        return res;
    }


    public int compute(int a, int b, char c) {
        switch (c) {
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
        }
        return 0;
    }
}
