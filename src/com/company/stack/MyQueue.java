package com.company.stack;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> queue;
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<>();
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(queue.size()+stack.size()==0) return true;
        return false;
    }
}
