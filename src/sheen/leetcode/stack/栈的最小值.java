package sheen.leetcode.stack;

import java.util.Stack;

public class 栈的最小值 {
    class MinStack {

        private int min = Integer.MAX_VALUE;
        private Stack<Integer> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if(x<=min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if(stack.isEmpty()) return;
            int item = stack.pop();
            if(item == min) {
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
}
