package com.company.array;

import java.util.Stack;

public class 比较含退格的字符串 {
    public static void main(String[] args) {
        比较含退格的字符串 s = new 比较含退格的字符串();
        System.out.println(s.backspaceCompare("y#fo##f","y#f#o##f"));
    }
    public boolean backspaceCompare(String S, String T) {
        int i = 0;
        int j = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        while(i<S.length()||j<T.length()) {
            if(i<S.length()) {
                if(S.charAt(i)=='#') {
                    if(!stack1.isEmpty()) stack1.pop();
                }
                else stack1.push(S.charAt(i));
                i++;
            }
            if(j<T.length()) {
                if(T.charAt(j)=='#') {
                    if(!stack2.isEmpty()) stack2.pop();
                } else stack2.push(T.charAt(j));
                j++;
            }
        }
        while(!stack1.isEmpty()&&!stack2.isEmpty()) {
            if(stack1.pop()!=stack2.pop()) return false;
        }
        if(stack1.isEmpty()&&stack2.isEmpty()) return true;
        return false;
    }
}
