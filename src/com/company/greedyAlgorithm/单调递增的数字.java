package com.company.greedyAlgorithm;

import java.util.Stack;

public class 单调递增的数字 {
    public static void main(String[] args) {
        单调递增的数字 s = new 单调递增的数字();
        System.out.println(s.monotoneIncreasingDigits(332));
    }
    public int monotoneIncreasingDigits(int N) {
        String num = String.valueOf(N);
        Stack<Character> stack = new Stack<>();
        boolean flag =false;
        for(int i=0;i<num.length();i++) {
            if(stack.isEmpty()) stack.push(num.charAt(i));
            else {
                if(!flag) {
                    if(stack.peek()>num.charAt(i)) {
                        Stack<Character> stack1 = new Stack<>();
                        char c = num.charAt(i);
                        while(!stack.isEmpty()&&stack.peek()>c) {
                            stack1.push('9');
                            c = (char) (stack.pop()-1);
                        }
                        stack.push(c);
                        while(!stack1.isEmpty()) stack.push(stack1.pop());
                        flag = true;
                    }else {
                        stack.push(num.charAt(i));
                    }
                }else {
                    stack.push('9');
                }
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return Integer.parseInt(res);
    }
}
