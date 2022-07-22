package sheen.leetcode.stack;

import java.util.*;

public class MinStack {


    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x<=min) {
            stack.push(min);
            min= x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
    /*public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }*/
