package com.company.stack;

import java.util.Stack;

public class 逆波兰表达式求值 {

    public static void main(String[] args) {
        逆波兰表达式求值 s = new 逆波兰表达式求值();
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(check(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (tokens[i]) {
                    case "+": stack.push(b+a);break;
                    case "-": stack.push(b-a);break;
                    case "*": stack.push(b*a);break;
                    case "/": stack.push(b/a);break;
                }
            }
        }
        return stack.peek();
    }

    public boolean check(String num) {
        for(int i=0;i<num.length();i++) {
            if(i==0&&(num.charAt(i)=='+'||num.charAt(i)=='-')&&num.length()>1) continue;
            if(num.charAt(i)<'0'||num.charAt(i)>'9') return false;
        }
        return true;
    }
}
