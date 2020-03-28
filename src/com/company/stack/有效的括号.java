package com.company.stack;

import java.util.Stack;

public class 有效的括号 {

    public static void main(String[] args) {
        有效的括号 s = new 有效的括号();
        System.out.println(s.isValid("{[]}("));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='['||chars[i]=='('||chars[i]=='{') {
                stack.push(chars[i]);
            } else if(stack.empty()) return false;
            if(chars[i]==')') {
                if(stack.peek()=='(') stack.pop();
                else return false;
            }
            if(chars[i]==']') {
                if(stack.peek()=='[') stack.pop();
                else return false;
            }
            if(chars[i]=='}') {
                if(stack.peek()=='{') stack.pop();
                else return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}
