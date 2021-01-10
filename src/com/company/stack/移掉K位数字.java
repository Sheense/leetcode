package com.company.stack;

import java.util.Stack;

public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<num.length();i++) {
            while(!stack.isEmpty()&&stack.peek()>num.charAt(i)&&k>0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k!=0) {
            stack.pop();
            k--;
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        for(int i=0;i<res.length();i++) {
            if(res.charAt(i)!='0') {
                res = res.substring(i);
                break;
            }
            if(i==res.length()-1) res = "0";
        }
        if(res.length()==0) res ="0";
        return res;
    }
}
