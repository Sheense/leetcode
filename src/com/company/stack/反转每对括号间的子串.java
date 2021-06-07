package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 反转每对括号间的子串 {
    public static void main(String[] args) {
        反转每对括号间的子串 s = new 反转每对括号间的子串();
        System.out.println(s.reverseParentheses("(((bcdefghijklmnopq)))"));
    }
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        int left = 0;
        int index = 0;
        while (index < s.length()) {
            if(s.charAt(index) == '(') {
                left ++;
                stack.push(String.valueOf(s.charAt(index)));
            }else if(s.charAt(index) == ')') {
                List<String> list = new ArrayList<>();
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop();
                String r = "";
                for(int i = 0; i < list.size(); i++) {
                    if(left % 2 == 0) {
                        r = list.get(i) + r;
                    } else {
                        r += list.get(i);
                    }
                }
                stack.push(r);
                left--;
            }else {
                stack.push(String.valueOf(s.charAt(index)));
            }
            index++;
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;

    }
}
