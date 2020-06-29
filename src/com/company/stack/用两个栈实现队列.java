package com.company.stack;

import java.util.Stack;

public class 用两个栈实现队列 {
    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack1.empty()&&stack2.empty()) return -1;
            else if(stack2.empty()) {
                while(!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
